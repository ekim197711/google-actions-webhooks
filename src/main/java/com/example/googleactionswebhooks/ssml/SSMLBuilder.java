package com.example.googleactionswebhooks.ssml;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class SSMLBuilder {
    private String inProgress="";
    public SSMLBuilder inpretAsCharacters(String sayas) {
        inProgress += "<say-as interpret-as=\"characters\">" +  sayas + "</say-as>";
        return this;
    }

    public SSMLBuilder pause(Integer time) {
        inProgress += "<break time=\"" + time + "\" />";
        return this;
    }

    public SSMLBuilder audio(String url, String description) {
        inProgress += String.format("<audio src=\"%s\">%s</audio>", url, description);
        return this;
    }

    public SSMLBuilder cardinal(Integer number) {
        inProgress += String.format("<say-as interpret-as=\"cardinal\">%d</say-as>", number);
        return this;
    }

    public SSMLBuilder ordinal(Integer number) {
        inProgress += String.format("<say-as interpret-as=\"ordinal\">%d</say-as>", number);
        return this;
    }

    public SSMLBuilder digits(Integer number) {
        inProgress += String.format("<say-as interpret-as=\"digits\">%d</say-as>", number);
        return this;
    }

    public SSMLBuilder substitutePhrase(String alias, String phrase) {
        inProgress += String.format("<sub alias=\"%s\">%s</sub>", alias, phrase);
        return this;
    }

    public SSMLBuilder paragraphMultiSentences(Collection<String> sentences) {
        String collect = sentences.stream()
                .collect(Collectors.joining("</s><s>"));
        collect = "<p><s>" + collect + "</s></p>";
        inProgress += collect;
        return this;
    }

    public SSMLBuilder say(String say){
        inProgress += say;
        return this;
    }

    public String build(){;
        return "<speak>" + inProgress + "</speak>";
    }
    public String buildRaw(){;
        return inProgress;
    }


    public static String DEMOExample(){
        return new SSMLBuilder()
        .say("Here are ")
        .inpretAsCharacters("SSML")
        .say(" samples. ")
        .say("I can pause ").pause(3).say(". ")
        .say("I can play a sound ").audio("https://www.example.com/MY_WAVE_FILE.wav","your wave file").say(". ")
        .say("I can speak in cardinals. Your position is ").cardinal(10).say(" in line. ")
        .say("Or I can speak in ordinals. You are ").ordinal(10).say(" in line. ")
        .say("Or I can even speak in digits. Your position in line is ").digits(10).say(".")
        .say(" I can also substitute phrases, like the ").substitutePhrase("World Wide Web Consortium","W3C").say(". ")
        .say("Finally, I can speak a paragraph with two sentences. ")
        .paragraphMultiSentences(List.of(
                "This is sentence one.",
                "This is sentence two."
        ))
        .build();
    }
//      const ssml = '<speak>' +
//            'Here are <say-as interpret-as="characters">SSML</say-as> samples. ' +
//            'I can pause <break time="3" />. ' +
//            'I can play a sound <audio src="https://www.example.com/MY_WAVE_FILE.wav">your wave file</audio>. ' +
//            'I can speak in cardinals. Your position is <say-as interpret-as="cardinal">10</say-as> in line. ' +
//            'Or I can speak in ordinals. You are <say-as interpret-as="ordinal">10</say-as> in line. ' +
//            'Or I can even speak in digits. Your position in line is <say-as interpret-as="digits">10</say-as>. ' +
//            'I can also substitute phrases, like the <sub alias="World Wide Web Consortium">W3C</sub>. ' +
//            'Finally, I can speak a paragraph with two sentences. ' +
//            '<p><s>This is sentence one.</s><s>This is sentence two.</s></p>' +
//            '</speak>';

}