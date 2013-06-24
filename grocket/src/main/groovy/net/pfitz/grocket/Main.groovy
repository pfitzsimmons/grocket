package net.pfitz.grocket;

import java.io.File;
import org.ho.yaml.Yaml;

public class Main
{
        public static void main(String[] arguments)
        {
            def input = '''
- 1
- apple
- orange
'''
            println "preyaml"
            print(Yaml.load(input))
            println("onemore line")
            println "postyaml"
            def file = new File("build.gradle");
        }
}