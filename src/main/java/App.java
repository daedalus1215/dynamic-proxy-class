import java.lang.reflect.Proxy;

public class App {

  @SuppressWarnings("unchecked")
  public static <T> T withLogging(T target, Class<T> itf) {
    return (T) Proxy.newProxyInstance(itf.getClassLoader(), new Class<?>[]{itf}, new PersonProxy(target));
  }

  public static void main(String[] args) {
    System.out.println("Hi");
    final Person person = new Person();

    final Human personProxy = withLogging(person, Human.class);
    personProxy.walk();
    personProxy.talk();
    personProxy.talk();
    System.out.println(personProxy.toString());
  }
}
