# Classgraph Issue 766

Here we show that classgraph does not handle jar://// or jar:file:/
the same way in classgraph 4.8.151 as it does before this version.

Execute `ClassgraphIssue766.java`

## Output with classgraph 4.8.150

```
Scan file:/home/alex/eclipse-workspace/core/classgraph-issue766/target/classes/com/github/alexsuter/classgraph/issue766/ProjectWithAnnotations.iar
Found: [ch.ivyteam.test.MyManagedBean]
Scan jar:file:/home/alex/eclipse-workspace/core/classgraph-issue766/target/classes/com/github/alexsuter/classgraph/issue766/ProjectWithAnnotations.iar
Found: [ch.ivyteam.test.MyManagedBean]
Scan jar:////home/alex/eclipse-workspace/core/classgraph-issue766/target/classes/com/github/alexsuter/classgraph/issue766/ProjectWithAnnotations.iar
Found: [ch.ivyteam.test.MyManagedBean]

```

## Output with classgraph 4.8.151

```
Scan file:/home/alex/eclipse-workspace/core/classgraph-issue766/target/classes/com/github/alexsuter/classgraph/issue766/ProjectWithAnnotations.iar
Found: [ch.ivyteam.test.MyManagedBean]
Scan jar:file:/home/alex/eclipse-workspace/core/classgraph-issue766/target/classes/com/github/alexsuter/classgraph/issue766/ProjectWithAnnotations.iar
Found: []
Scan jar:////home/alex/eclipse-workspace/core/classgraph-issue766/target/classes/com/github/alexsuter/classgraph/issue766/ProjectWithAnnotations.iar
Found: []
```
