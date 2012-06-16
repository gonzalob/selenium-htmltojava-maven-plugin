# selenium-htmltojava-maven-plugin #

Using [Selenium IDE](http://seleniumhq.org/projects/ide/) to automate web 
testing is really easy. It's not so easy, though, to automate execution of 
those tests.

## Motivation ##

In a Maven project, you can try to use 
[maven-selenium-plugin](http://mojo.codehaus.org/selenium-maven-plugin/) to 
accomplish the task. It is possible to do so, but it has some limitations that 
were deal breakers for us, such as the inability to run in a remote selenium 
server.
Most of those limitations are lifted when using jUnit tests instead of 
recorded Selenium IDE scripts, but those require skills in our testing teams 
or time from our development teams that we currently do not have.

Selenium IDE can save a test as a jUnit case, but then it cannot open it. As a 
one way street, it is unsuitable for a testing team without programming skills.

## Objective ##

This plugin is an attempt to release the testing teams from manual, repetitive 
work, enabling the tests execution to be automated in a versatile way, and 
not disabling the testers' ability to run each test as they please in the IDE.

# Why? #

I don't think this is ultimately a good testing strategy. It is far from 
maintainable, or flexible. But...
Right now, our testing teams are filled with work, so they don't get time to 
learn a programming language, so they can't automate, so they get even less 
time. This is a negative feedback loop, and has to be broken somehow.

By automating the tests in, say, a nightly build, we'll get the desired 
feedback every morning, without any effort from testing besides recording.

## Usage ##

As a Maven plugin, this artifact should be plugged to the 
generate-test-sources lifecycle phase, as it will try to parse Selenium IDE 
scripts and build jUnit test cases to be run by 
[failsafe](http://maven.apache.org/plugins/maven-failsafe-plugin/) or
[surefire](http://maven.apache.org/plugins/maven-surefire-plugin/).

## Configuration ##

By default, the plugin will:
 - look for files in src/test/html
 - Attempt to parse every file in that directory
 - _NOT_ run. skip defaults to true!
 - connect to a Selenium server in localhost:4444
 - Build tests suffixed by ITCase, so failsafe will pick them by default

All of these settings, and some other, less relevant ones, can be overriden in 
the plugin's configuration.

## Next Steps ##

One of the key components of the plugin is the Commands class, which holds the 
knowledge of how to translate each Selenium IDE command to Java statements 
that do the same.
This class is hardly complete. It is enough so far for the scripts written by 
the teams I'm currently working with, but they keep learning commands and the 
list is only getting bigger.
