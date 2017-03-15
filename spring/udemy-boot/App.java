@RestController
public class App {

  @RequestMapping("/")
  public String home(){
    return "hello world"
  }

}
