package hello;

/**
 * Created by AMYLIN on 2/09/17.
 */

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World, this is my first Gradle project!")
                                         String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
