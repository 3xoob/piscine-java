# piscine-java

A collection of small, self-contained Java exercises written while working through a "piscine" (bootcamp-style) Java curriculum, progressing from basic syntax to collections, I/O, object-oriented design, and classic design patterns.

## Overview

The repository is not a single application — it is a set of 64 independent exercise folders at the repository root. Each folder holds one or more plain `.java` source files (no packages, no build tool) implementing a focused exercise: a utility class with static methods, or a small group of classes/interfaces modeling a mini domain (an adventure game, a solar system, a raclette, etc.). There is no `main` method anywhere in the codebase, so the exercises are designed to be exercised by unit tests or a checker rather than run as standalone programs.

## Features

Exercises are grouped below by topic, based on how they were introduced in the repository's commit history:

- **Java basics** (`HelloWorld`, `IsEven`, `IntOperations`, `FloatOperations`, `StringLength`, `StringContains`, `StringReplace`, `StringConcat`, `ComputeArray`, `Palindrome`, `Chifoumi`, `CleanExtract`) — primitives, strings, arrays, enums, and simple parsing/formatting logic.
- **Object-oriented basics** (`StarConstructors`, `StarGalaxy`, `StarGetters`, `StarInheritance`, `StarMass`, `StarOverride`, `StarPlanet`, `StarProperties`, `StarStatic`, `StarUtils`) — a `CelestialObject`/`Star`/`Planet`/`Galaxy` model used to practice constructors, encapsulation, inheritance, method overriding, and static members.
- **I/O and command-line arguments** (`Capitalize`, `Cat`, `CatInFile`, `DoOp`, `FileManager`, `FileSearch`, `SortArgs`) — reading/writing files with `java.nio.file` and `java.io` streams, and processing `String[] args`-style input.
- **Collections and streams** (`KeepTheChange`, `ListContains`, `ListEquals`, `ListSearchIndex`, `MapEquals`, `MapInventory`, `SetEquals`, `SetOperations`, `SortList`, `StreamCollect`, `StreamMap`, `StreamReduce`, `Wedding`, `WeddingComplex`) — `List`/`Set`/`Map` manipulation and the `java.util.stream` API (`map`, `reduce`, `collect`).
- **Advanced OOP** (`AdventureAbstract`, `AdventureCatch`, `AdventureCharacter`, `AdventureException`, `AdventureInterface`, `AdventureMonster`, `AdventureSorcerer`, `AdventureTemplar`, `AdventureUtils`, `AdventureWeapon`) — an evolving turn-based "adventure" domain (`Character`, `Monster`, `Templar`, `Sorcerer`, `Healer`, `Weapon`) used to practice abstract classes, interfaces, and custom checked exceptions (`DeadCharacterException`).
- **Java standard library** (`DifferenceBetweenDate`, `FormatDate`, `ParseDate`, `RegexMatch`, `RegexReplace`) — `java.time` (`LocalDate`, `LocalDateTime`, `LocalTime`, `DateTimeFormatter`) and regular expressions (`String.matches`, pattern replace).
- **Design patterns** (`Builder`, `Decorator`, `Factory`, `Observer`, `Singleton`, `Strategy`) — one canonical implementation of each pattern (e.g. `HouseBuilder`/`ApartmentBuilder`, `RacletteDecorator` with `WithColdMeats`/`WithPickles`, `DriverFactory`, `ValuePublisher`/`NumericBaseObserver`, `Excalibur` singleton, `Context`/`OperationStrategy`).

## Technologies

- Java (plain `.java` source files, default/unnamed package — no `package` declarations anywhere in the repository)
- No Maven, Gradle, or other build tool is configured (no `pom.xml` or `build.gradle` files are present)
- Uses standard JDK APIs only: `java.util` collections, `java.util.stream`, `java.time`, `java.io`, `java.nio.file`, and `java.util.regex`

## Project Structure

The repository is a flat list of 64 exercise directories at the root, each named after its exercise (e.g. `HelloWorld/`, `StreamReduce/`, `AdventureException/`). A directory typically contains:

- One primary class matching the directory name (e.g. `Palindrome/Palindrome.java`), holding the exercise's static methods, or
- Several related classes/interfaces for exercises modeling a small domain (e.g. `Factory/` contains `Car.java`, `CarDriver.java`, `Driver.java`, `DriverFactory.java`, `Plane.java`, `PlaneDriver.java`, `Transport.java`, `TransportFactory.java`).

There are no per-exercise README/subject files, no test directories, and no CI configuration in the repository.

Root files:
- `LICENSE` / `COPYRIGHT.md` — proprietary "all rights reserved" copyright notice
- `.gitignore` — ignores secrets, build output, and editor/OS files

## Requirements

- A JDK capable of compiling the language features used in the code (the `java.time` package and the Stream API require at least Java 8). No specific JDK version is pinned anywhere in the repository.

## Installation

Clone the repository and compile whichever exercise you want to try, there is no shared build step:

```bash
git clone https://github.com/3xoob/piscine-java.git
cd piscine-java
```

## Usage

Each exercise is compiled and used independently with the plain `javac`/`java` toolchain, since there is no build tool. For example, to compile and try the `HelloWorld` exercise:

```bash
javac HelloWorld/HelloWorld.java -d out
java -cp out HelloWorld
```

Because none of the classes declare a `main` method, invoking a class directly with `java` will not do anything on its own — the classes expose static methods (or small object models) meant to be called from your own test/driver code or an external checker. For example, calling into a two-file exercise:

```bash
javac Palindrome/Palindrome.java -d out
```

then, from your own `Main.java` (not included in this repository):

```java
System.out.println(Palindrome.isPalindrome("kayak")); // true
```

## Example

`RegexMatch/RegexMatch.java` checks strings against small regular expressions:

```java
RegexMatch.containsOnlyAlpha("Hello");                    // true
RegexMatch.startWithLetterAndEndWithNumber("Room42");      // true
RegexMatch.containsAtLeast3SuccessiveA("baAAAd");          // true
```

## Learning Objectives

Based strictly on the exercises present, this repository practices:

- Core Java syntax: primitives, strings, arrays, control flow, and enums
- Object-oriented fundamentals: constructors, encapsulation, inheritance, method overriding, and static members
- File I/O and command-line argument handling with `java.io` and `java.nio.file`
- The Collections Framework (`List`, `Set`, `Map`) and the Stream API
- Abstract classes, interfaces, and custom checked exceptions in a multi-class domain model
- The `java.time` date/time API and regular expressions
- Classic design patterns: Builder, Decorator, Factory, Observer, Singleton, and Strategy

## Limitations

- No build tool (Maven/Gradle) is configured, so there is no single command to compile or run every exercise at once.
- No automated tests or CI configuration are included in the repository.
- No `main` methods are present, so exercises cannot be run directly without external driver/test code.

## License

This project is distributed under an "all rights reserved" copyright (see `LICENSE` and `COPYRIGHT.md`): the source code is publicly viewable for portfolio purposes only, and no permission is granted to copy, modify, distribute, or reuse it without prior written permission from the copyright holder.
