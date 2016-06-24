package com.kloudtek.idvkey.api.util;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.HashSet;

/**
 * Created by yannick on 3/6/16.
 */
public class GenerateSchema {
    public static void main(String[] args) throws Exception {
        File file = args.length > 0 ? new File(args[0]) : null;
        Reflections reflections = new Reflections("com.kloudtek.idvkey.api");
        HashSet<Class> classes = new HashSet<>();
        for (Class<?> cl : reflections.getTypesAnnotatedWith(JsonClassDescription.class)) {
            if (cl.getEnclosingClass() == null) {
                classes.add(cl);
            }
        }
        for (Class cl : classes) {
            String filename = toJsonFilename(cl.getSimpleName());
            System.out.println("Generating json for " + filename);
            ObjectMapper m = new ObjectMapper();
            m.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
            m.acceptJsonFormatVisitor(m.constructType(cl), visitor);
            com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
            StringWriter buf = new StringWriter();
            m.writerWithDefaultPrettyPrinter().writeValue(buf, jsonSchema);
            String schema = buf.toString();
            if( file != null ) {
                try( FileWriter fw = new FileWriter(new File(file, filename)) ) {
                    fw.write(schema);
                }
            } else {
                System.out.println(schema);
            }
        }
    }

    @NotNull
    private static String toJsonFilename(String className) {
        if( className.equals("APIKeyBundle") ) {
            className = "ApiKeyBundle";
        }
        char[] chars = className.toCharArray();
        StringBuilder filename = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if( Character.isUpperCase(c) ) {
                filename.append(Character.toLowerCase(c));
            } else {
                filename.append(c).append(className.substring(i+1));
                break;
            }
        }
        return filename.append(".json").toString();
    }
}
