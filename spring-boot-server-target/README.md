
## Run Spring Boot application
```
mvn spring-boot:run
```


## 💻Target Room Backend Project💻



### 💡 Why Spring Boot 
Spring Boot offers a combination of rapid development and various features that make building backend applications efficient and effective.
 - Microservices Architecture: It provides features and tools that support building, deploying...
 -  Auto-Configuration: automatically configures application components based on the project's dependencies.
 - Dependency Management:that offers a powerful dependency management system that helps manage and resolve dependencies with minimal effort.
 - Testing Support: including the ability to write unit tests, integration tests, and end-to-end tests.

### 🚀 What is Idea of project 

The idea consists of Ranging Target Room application implemented as an Angular  application, and a ``RESTful web service`` implemented as a Spring Boot application, that communicate via a ``REST API`` .

The back-end adheres to the Model-View-Controller``MVC`` architecture, ensuring a clear separation of concerns and streamlined development. This separation of concerns enhances code readability, as each component focuses on its designated role.

This application executes some GET requests on the web server to display target and product aivalability on the user interface.

 It then processes these request to properly display the availability of those tools and provide the necessary operations to manage data, such as adding new records, retrieving existing data, updating information, and removing records from the underlying data source while using ```CRUD``` application. 


#### Built With


<a href="https://spring.io/projects/spring-boot" rel="nofollow">
  <img src="https://img.shields.io/badge/Spring_Boot-3.1.2-brightgreen?style=for-the-badge&amp;logo=spring&amp;logoColor=white"
       alt="Spring Boot Badge">
</a>
<a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html" rel="nofollow">
  <img src="https://img.shields.io/badge/Java_JDK-17-orange?style=for-the-badge&amp;logo=java&amp;logoColor=white"
       alt="Java JDK Badge">
</a>
<a href="https://dev.mysql.com/downloads/mysql/" rel="nofollow">
  <img src="https://img.shields.io/badge/MySQL-8.1-blue?style=for-the-badge&amp;logo=mysql&amp;logoColor=white"
       alt="MySQL Badge">
</a>
<a href="https://maven.apache.org/" rel="nofollow">
  <img src="https://img.shields.io/badge/Maven-3.9.3-C71A36?style=for-the-badge&amp;logo=apache-maven&amp;logoColor=white"
       alt="Maven Badge">
</a>


### Guide 

<a href="https://spring.io/guides" rel="nofollow">
  <img src="https://img.shields.io/badge/Spring_Boot_Guide-Reference-yellow?style=for-the-badge&amp;logo=spring&amp;logoColor=white"
       alt="Spring Boot Guide Badge">
</a>


### 📢 Use Target Room Backend in 4 steps

1. Setup by installing Java Development Kit (JDK) and development environment (IDE).

2. Configure MySQL database  in the ```application.properties``` .

3. Implement API Endpoints.
4. Test Your Application by running your Spring Boot application ```Run java ```.

### 🔐 Instalation Prerequisites:

- Install Java Development Kit (JDK):

```
npm install -g @angular/cli
```
- Choose an Integrated Development Environment (IDE) as [IntelliJ IDEA](https://www.jetbrains.com/help/idea/installation-guide.html#requirements), [Eclipse](https://www.eclipse.org/downloads/packages/installer), or [Visual Studio Code](https://code.visualstudio.com/download) .

-  Install [MySQL](https://dev.mysql.com/) Database.


### ⚙️ Getting Started
#### Instalation

1. Clone repo
```
https://github.com/EmnaSallemi/full-stack-targetroom-internship.git
```
2. Installing Dependencies:
  ```mvn install```

3. Run Development Server using Java-based application: 
```run java```

 4. Testing code while using [Postman](https://www.postman.com/)



#### Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.



## 🏆 Contributing
Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are <strong>greatly appreciated</strong>.

  1. Fork the Project.

  2. Create your Feature Branch (```git checkout -b feature/AmazingFea```)

  3. Commit your Changes (```git commit -m 'Add some AmazingFeature```)

  4. Push to the Branch (```git push origin feature/AmazingFeature```)

  5. Open a Pull Request.

  6. [ Frontend contributing guide](https://github.com/EmnaSallemi/frontend_targetroom.git)
 





## Tables

| Option | Description |
| ------ | ----------- |
| data   | path to data files to supply the data that will be passed into templates. |
| engine | engine to be used for processing templates. Handlebars is the default. |
| ext    | extension to be used for dest files. |

Right aligned columns

| Option | Description |
| ------:| -----------:|
| data   | path to data files to supply the data that will be passed into templates. |
| engine | engine to be used for processing templates. Handlebars is the default. |
| ext    | extension to be used for dest files. |


## Links

[link text](http://dev.nodeca.com)

[link with title](http://nodeca.github.io/pica/demo/ "title text!")

Autoconverted link https://github.com/nodeca/pica (enable linkify to see)


## Images

![Minion](https://octodex.github.com/images/minion.png)
![Stormtroopocat](https://octodex.github.com/images/stormtroopocat.jpg "The Stormtroopocat")

Like links, Images also have a footnote style syntax

![Alt text][id]

With a reference later in the document defining the URL location:

[id]: https://octodex.github.com/images/dojocat.jpg  "The Dojocat"


## Plugins


The killer feature of `markdown-it` is very effective support of
[syntax plugins](https://www.npmjs.org/browse/keyword/markdown-it-plugin).


### [Emojies](https://github.com/markdown-it/markdown-it-emoji)

> Classic markup: :wink: :crush: :cry: :tear: :laughing: :yum:
>
> Shortcuts (emoticons): :-) :-( 8-) ;)

see [how to change output](https://github.com/markdown-it/markdown-it-emoji#change-output) with twemoji.


### [Subscript](https://github.com/markdown-it/markdown-it-sub) / [Superscript](https://github.com/markdown-it/markdown-it-sup)

- 19^th^
- H~2~O


### [\<ins>](https://github.com/markdown-it/markdown-it-ins)

++Inserted text++


### [\<mark>](https://github.com/markdown-it/markdown-it-mark)

==Marked text==


### [Footnotes](https://github.com/markdown-it/markdown-it-footnote)

Footnote 1 link[^first].

Footnote 2 link[^second].

Inline footnote^[Text of inline footnote] definition.

Duplicated footnote reference[^second].

[^first]: Footnote **can have markup**

    and multiple paragraphs.

[^second]: Footnote text.


### [Definition lists](https://github.com/markdown-it/markdown-it-deflist)

Term 1

:   Definition 1
with lazy continuation.

Term 2 with *inline markup*

:   Definition 2

        { some code, part of Definition 2 }

    Third paragraph of definition 2.

_Compact style:_

Term 1
  ~ Definition 1

Term 2
  ~ Definition 2a
  ~ Definition 2b


### [Abbreviations](https://github.com/markdown-it/markdown-it-abbr)

This is HTML abbreviation example.

It converts "HTML", but keep intact partial entries like "xxxHTMLyyy" and so on.

*[HTML]: Hyper Text Markup Language

### [Custom containers](https://github.com/markdown-it/markdown-it-container)

::: warning
*here be dragons*
:::

# TargetRoom

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.1.4.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

``` js
var foo = function (bar) {
  return bar++;
};

console.log(foo(5));
```



To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
#� �T�A�R�G�E�T�_�R�O�O�M�_�S�t�a�g�e�
�
�
#