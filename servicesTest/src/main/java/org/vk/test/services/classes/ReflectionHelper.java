package org.vk.test.services.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class ReflectionHelper {
  /** Se ofusca el contructor */
  private ReflectionHelper() {}

  /**
   * Establece el valor de una propiedad por medio de reflexi&oacute;n
   * 
   * @param value Valor a settear
   * @param fieldName El nombre del atributo (
   * @param myInstance
   */
  public static void set( Object value, String fieldName, Object myInstance ) {
    try {
      Class<?> clazz = getClassFor( myInstance, fieldName );
      Field field = clazz.getDeclaredField( fieldName );
      makeAccessible( field );
      field.set( myInstance, value );
    }
    catch( SecurityException e ) {
      System.err.println( e.getMessage() );
    }
    catch( NoSuchFieldException e ) {
      System.err.println( e.getMessage() );
    }
    catch( IllegalArgumentException e ) {
      System.err.println( e.getMessage() );
    }
    catch( IllegalAccessException e ) {
      System.err.println( e.getMessage() );
    }

  }

  /**
   * Obtiene el valor del atributo dado el nombre y la instancia de la clase
   * 
   * @param fieldName
   * @param myInstance
   * @return
   */
  public static Object get( String fieldName, Object myInstance ) {
    Object value = null;
    try {
      Class<?> clazz = getClassFor( myInstance, fieldName );
      Field field = clazz.getDeclaredField( fieldName );
      makeAccessible( field );
      value = field.get( myInstance );
    }
    catch( SecurityException e ) {
      System.err.println( e.getMessage() );
    }
    catch( NoSuchFieldException e ) {
      System.err.println( e.getMessage() );
    }
    catch( IllegalArgumentException e ) {
      System.err.println( e.getMessage() );
    }
    catch( IllegalAccessException e ) {
      System.err.println( e.getMessage() );
    }
    return value;
  }

  @SuppressWarnings( "rawtypes" )
  private static Class getClassFor( Object myInstance, String fieldName ) {
    Class clazz = myInstance.getClass();

    boolean fieldNameFound = false;
    while( true ) {
      for( Field field : clazz.getDeclaredFields() ) {
        if( field.getName().equals( fieldName ) ) {
          fieldNameFound = true;
          break;
        }
      }

      if( fieldNameFound ) {
        break;
      }
      if( clazz.getSuperclass() != null ) {
        clazz = clazz.getSuperclass();
      } else {
        break;
      }
    }
    return clazz;
  }

  public static void makeAccessible( Field field ) {
    if( ( ( Modifier.isPublic( field.getModifiers() ) ) && ( Modifier.isPublic( field.getDeclaringClass().getModifiers() ) ) && ( !( Modifier.isFinal( field.getModifiers() ) ) ) )
            || ( field.isAccessible() ) )
      return;
    field.setAccessible( true );
  }

  public static void makeAccessible( Method method ) {
    if( ( ( Modifier.isPublic( method.getModifiers() ) ) && ( Modifier.isPublic( method.getDeclaringClass().getModifiers() ) ) ) || ( method.isAccessible() ) )
      return;
    method.setAccessible( true );
  }

  public static void makeAccessible( Constructor<?> ctor ) {
    if( ( ( Modifier.isPublic( ctor.getModifiers() ) ) && ( Modifier.isPublic( ctor.getDeclaringClass().getModifiers() ) ) ) || ( ctor.isAccessible() ) )
      return;
    ctor.setAccessible( true );
  }
}
