package org.vk.test.services.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractDBEJBTestUnit
{
  private Map<Class<?>, Class<?>> mapDAO;

  private EntityManager em;

  @Before
  public void setUp()
  {
    if( em == null )
    {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory( "persistenceUnitTest" );
      em = emf.createEntityManager();
      initMapDAO();
    }
  }

  public void initializeData( String path )
  {
    if( !em.getTransaction().isActive() )
    {
      em.getTransaction().begin();
    }

    InputStream is = ClassLoader.getSystemResourceAsStream( path );
    InputStreamReader isr = new InputStreamReader( is );
    BufferedReader br = new BufferedReader( isr );
    String line;
    Query query = null;
    try
    {
      line = br.readLine();
      while( line != null )
      {
        if( line.length() > 20 && line.indexOf( "//" ) != 0 )
        {
          query = em.createNativeQuery( line );
          query.executeUpdate();
          em.flush();
        }
        line = br.readLine();
      }
    }
    catch( IOException e )
    {
      e.printStackTrace();
    }
    finally
    {
      safeCloseBufferedReader( br );
    }
  }

  private void safeCloseBufferedReader( BufferedReader br )
  {
    if( br != null )
    {
      try
      {
        br.close();
      }
      catch( IOException e )
      {
        br = null;
      }
    }
  }

  private void initMapDAO()
  {
    // Agregar las relaciones de DAO y sus implementaciones
    mapDAO = new HashMap<Class<?>, Class<?>>();
  } 
  
  public void addDAOToMap(Class<?> daoClass)
  {
    mapDAO.put( daoClass, daoClass );
  }

  protected void connect( Object o )
  {
    try
    {
      Field[] fields = o.getClass().getDeclaredFields();
      for( Field field : fields )
      {
        EJB ejb = field.getAnnotation( javax.ejb.EJB.class );
        if( ejb != null )
        {
          String className = field.getType().getCanonicalName();
          System.out.println( className );
          Class<?> clazz = Class.forName( className );
          if( this.mapDAO.containsKey( clazz ) )
          {
            Constructor<?> ctor = this.mapDAO.get( clazz ).getConstructor();
            Object dao = ctor.newInstance();
            Field[] fieldDAOs = dao.getClass().getDeclaredFields();
            for( Field fieldDAO : fieldDAOs )
            {
              PersistenceContext persistenceContext = fieldDAO.getAnnotation( PersistenceContext.class );
              if( persistenceContext != null )
              {
                ReflectionHelper.set( this.em, fieldDAO.getName(), dao );
                ReflectionHelper.set( dao, field.getName(), o );
                break;
              }
            }
          }
        }
      }
    }
    catch( ClassNotFoundException e )
    {
      System.err.println( e.getMessage() );
    }
    catch( SecurityException e )
    {
      System.err.println( e.getMessage() );
    }
    catch( NoSuchMethodException e )
    {
      System.err.println( e.getMessage() );
    }
    catch( IllegalArgumentException e )
    {
      System.err.println( e.getMessage() );
    }
    catch( InstantiationException e )
    {
      System.err.println( e.getMessage() );
    }
    catch( IllegalAccessException e )
    {
      System.err.println( e.getMessage() );
    }
    catch( InvocationTargetException e )
    {
      System.err.println( e.getMessage() );
    }
  }

  @After
  public void tearDown()
  {
    em.getTransaction().rollback();
  }

  public EntityManager getEntityManager()
  {
    return this.em;
  }
}
