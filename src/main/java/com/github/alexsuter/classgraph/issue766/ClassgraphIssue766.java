package com.github.alexsuter.classgraph.issue766;

import java.util.Set;
import java.util.stream.Collectors;

import io.github.classgraph.ClassGraph;

public class ClassgraphIssue766 {
  
  public static void main(String[] args) {
    var url = ClassgraphIssue766.class.getResource("ProjectWithAnnotations.iar");

    var fileUrl = "file:" + url.getPath();
    var jarFileUrl = "jar:file:" + url.getPath();
    var jarUrl = "jar:///" + url.getPath();
    
    // this does work
    System.out.println("Found: " + scan("javax.annotation.ManagedBean", fileUrl));
    // this does not work
    System.out.println("Found: " + scan("javax.annotation.ManagedBean", jarFileUrl));
    System.out.println("Found: " + scan("javax.annotation.ManagedBean", jarUrl));
  }

  public static Set<String> scan(String annotation, String url) {
    System.out.println("Scan " + url);
    var classGraph = new ClassGraph()
            //.verbose(true)
            .overrideClasspath(Set.of(url))
            .disableNestedJarScanning()
            .enableAnnotationInfo();
    try (var result = classGraph.scan()) {
      return result.getClassesWithAnnotation(annotation)
                .getStandardClasses()
                .getNames()
                .stream()
                .collect(Collectors.toSet());
    }
  }
}
