//package template;
//
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
//
//public class GenerateStringTest {
//    private Generator generator = new GenerateString();
//    private final String template = "I am a ${name}, Who are ${subject}? ";
//
//    @Test
//    public void produceWhenArgsEqualsKeys() {
//        Map<String, String> keys = new HashMap<>();
//        keys.put("name", "Nick");
//        keys.put("subject", "you");
//        String expected = "I am Nick, Who are you?";
//        assertThat(generator.produce(template, keys), is(expected));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void produceWhenMoreArgsThenKeys() {
//        Map<String, String> keys = new HashMap<>();
//        keys.put("name", "Nick");
//        generator.produce(template, keys);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void produceWhenMoreKeysThenArgs() {
//        Map<String, String> keys = new HashMap<>();
//        keys.put("name", "Nick");
//        keys.put("subject", "you");
//        keys.put("surname", "Manko");
//        generator.produce(template, keys);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void produceWhenArgNotInTemplate() {
//        Map<String, String> keys = new HashMap<>();
//        keys.put("name", "Nick");
//        keys.put("surname", "Manko");
//        generator.produce(template, keys);
//    }
//}