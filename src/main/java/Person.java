public class Person implements Human {

  @Override
  public void walk() {
    System.out.println("Walking");
  }

  @Override
  public void talk() {
    System.out.println("Talking");
  }
}
