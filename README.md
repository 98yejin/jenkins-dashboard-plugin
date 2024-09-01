# jenkins-dashboard-plugin

## Introduction

- Real-time monitoring of jobs, including the ability to check pipeline stages for pipelines.
- View records of success and failure within a selected time range, with links provided.
- Filter cron jobs and other types of jobs.
- View job/pipeline configurations and history.

## Development

### Getting Started:

To start the application:

```shell
mvn hpi:run
```

### Check Code Formatting:

To automatically format your code according to the project’s style guidelines:

```shell
mvn spotless:apply
```

### Build the Plugin:

Make sure the plugin can be built successfully:

```shell
mvn clean verify
mvn dependency:analyze
```


## Issues

TODO Decide where you're going to host your issues, the default is Jenkins JIRA, but you can also enable GitHub issues,
If you use GitHub issues there's no need for this section; else add the following line:

Report issues and enhancements in the [Jenkins issue tracker](https://issues.jenkins.io/).

## Contributing

TODO review the default [CONTRIBUTING](https://github.com/jenkinsci/.github/blob/master/CONTRIBUTING.md) file and make sure it is appropriate for your plugin, if not then add your own one adapted from the base file

Refer to our [contribution guidelines](https://github.com/jenkinsci/.github/blob/master/CONTRIBUTING.md)

## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)

