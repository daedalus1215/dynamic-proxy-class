import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class PersonProxy implements InvocationHandler {
  private final Object target;
  private Map<String, Integer> calls = new HashMap<>();

  public PersonProxy(Object target) {
    this.target = target;
  }

  /**
   * If the method is `toString` we want to override that method with our own stringif'ied calls
   * @param proxy
   * @param method
   * @param args
   * @return
   * @throws Throwable
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    final String name = method.getName();
    if (name.contains("toString")) {
      return calls.toString();
    }
    calls.merge(name, 1, Integer::sum);
    return method.invoke(target, args);
  }
}
