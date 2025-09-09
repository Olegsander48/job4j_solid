package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Test are disabled. Enable them after implementing PhraseGenerator")
class PhraseGeneratorTest {
    @Test
    void whenPassTemplateAndArgsThenGetGreetingString() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "Hello ${name}, how are you?";
        Map<String, String> args = Map.of("name", "John");
        assertThat(generator.produce(template, args))
                .isEqualTo("Hello John, how are you?");
    }

    @Test
    void whenPassTemplateAndSeveralArgsThenGetGreetingString() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "Hello ${name} ${surname}, how are you? How your ${pet}?";
        Map<String, String> args = Map.of("name", "John",
                                        "surname", "Lenon",
                                        "pet", "cat");
        assertThat(generator.produce(template, args))
                .isEqualTo("Hello John Lenon, how are you? How your cat?");
    }

    @Test
    void whenPassInvalidTemplateAndArgsThenGetGreetingString() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "Hello @{name} %%{surname}, how are you? How your #{pet}?";
        Map<String, String> args = Map.of("name", "John",
                "surname", "Lenon",
                "pet", "cat");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Template must match pattern: text ${placeholder}, some additional info ${placeholder}.");
    }

    @Test
    void whenPassOnlyArgsThenGetException() {
        PhraseGenerator generator = new PhraseGenerator();
        Map<String, String> args = Map.of("name", "John");
        assertThatThrownBy(() -> generator.produce(null, args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Template cannot be null");
    }

    @Test
    void whenPassEmptyTemplateThenGetException() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "       ";
        Map<String, String> args = Map.of("name", "John");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Template cannot be empty/blank");
    }

    @Test
    void whenPassTemplateWithoutPlaceholdersThenGetException() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "Hello Billy, how are you? How was your day?";
        Map<String, String> args = Map.of("name", "John",
                "surname", "Lenon",
                "pet", "cat");
        assertThatThrownBy(() -> generator.produce(template, args))
        .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Template must have a placeholders");
    }

    @Test
    void whenPassTemplateAndNoArgsThenGetException() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "Hello ${name}, how are you?";
        Map<String, String> args = Map.of();
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No arguments passed");
    }

    @Test
    void whenPassMoreArgsThanExpectedThenGetException() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "Hello ${name}, how are you?";
        Map<String, String> args = Map.of("name", "John",
                                        "age", "20");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong number of arguments: expected 1, got 2");
    }

    @Test
    void whenPassOnlyTemplateThenGetException() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "Hello ${name}, how are you?";
        assertThatThrownBy(() -> generator.produce(template, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Arguments cannot be null");
    }

    @Test
    void whenPassWrongArgsThenGetException() {
        PhraseGenerator generator = new PhraseGenerator();
        String template = "Hello ${name}, how are you?";
        Map<String, String> args = Map.of("animal", "Chinchilla");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong arguments: expected {name}, got {animal}");
    }
  
}