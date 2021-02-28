# Dumb Dog Diner Contribution Guidelines

The following is a set of guidelines for contributing to plugins used on the dddMC, which are hosted in the [DDD Organization](https://github.com/DumbDogDiner) on GitHub. These are mostly guidelines, not rules. Use your best judgment, and feel free to propose changes to this document in a pull request.

#### Table Of Contents

[Code of Conduct](#code-of-conduct)

[What should I know before I get started?](#what-should-i-know-before-i-get-started)

[How Can I Contribute?](#how-can-i-contribute)

-   [Reporting Bugs](#reporting-bugs)
-   [Suggesting Enhancements](#suggesting-enhancements)
-   [Your First Code Contribution](#your-first-code-contribution)
-   [Pull Requests](#pull-requests)

[Styleguides](#styleguides)

-   [Git Commit Messages](#git-commit-messages)
-   [TypeScript Styleguide](#typescript-styleguide)
-   [Kotlin Styleguide](#kotlin-styleguide)
-   [Documentation Styleguide](#documentation-styleguide)

[Additional Notes](#additional-notes)

-   [Issue and Pull Request Labels](#issue-and-pull-request-labels)

## What should I know before I get started?

### APIs We Utilise

### StickyAPI

This is our in-house code library for all of our plugins, it helps make our codebase more consistent and easier to work together with.

-   [GitHub](https://github.com/DumbDogDiner/StickyAPI/)
-   [Docs](https://dumbdogdiner.github.io/StickyAPI/)

### Placeholder API

We use Placeholder API for all of our placeholders in our plugins.

-   [Spigot](https://www.spigotmc.org/resources/placeholderapi.6245/)
-   [Docs](https://github.com/PlaceholderAPI/PlaceholderAPI/wiki/Hook-into-PlaceholderAPI)

### Vault API

-   [GitHub](https://github.com/MilkBowl/VaultAPI)

### Packets and Protocols

experienced devs may use [NMS packets](https://wiki.vg/Protocol)

There is, however, a slightly easier to use alternative called ProtocolLib

-   [Spigot](https://www.spigotmc.org/resources/protocollib.1997/)
-   [Docs](https://github.com/dmulloy2/ProtocolLib/wiki/Adding-ProtocolLib-as-a-Dependency)

### MySQL and PostgreSQL

We use MySQL and PostgreSQL for our SQL Databases

-   [MySQL](https://dev.mysql.com/doc/)
-   [PostgreSQL](https://www.postgresql.org/docs/)

_(It is prefered that you use PostgreSQL where possible)_

### Package Manager

It is highly recommended to use a package manager for your project.
We recommend Gradle

-   [Gradle](https://docs.gradle.org/)

### Suggesting Enhancements

This section guides you through submitting an enhancement suggestion for DumbDogDiner plugins, including completely new features and minor improvements to existing functionality. Following these guidelines helps maintainers and the community understand your suggestion :pencil: and find related suggestions :mag_right:.

Before creating enhancement suggestions, please check [this list](#before-submitting-an-enhancement-suggestion) as you might find out that you don't need to create one. When you are creating an enhancement suggestion, please [include as many details as possible](#how-do-i-submit-a-good-enhancement-suggestion). Fill in [the template](https://github.com/DumbDogDiner/.github/ISSUE_TEMPLATE/feature_request.md), including the steps that you imagine you would take if the feature you're requesting existed.

#### Before Submitting An Enhancement Suggestion

-   **Determine which repository the enhancement should be suggested in.**
-   **Perform a [cursory search](https://github.com/search?q=+is%3Aissue+user%3Adumbdogdiner)** to see if the enhancement has already been suggested. If it has, add a comment to the existing issue instead of opening a new one.

#### How Do I Submit A (Good) Enhancement Suggestion?

Enhancement suggestions are tracked as [GitHub issues](https://guides.github.com/features/issues/). After you've determined which repository your enhancement suggestion is related to, create an issue on that repository and provide the following information:

-   **Use a clear and descriptive title** for the issue to identify the suggestion.
-   **Provide a step-by-step description of the suggested enhancement** in as many details as possible.
-   **Provide specific examples to demonstrate the steps**. Include copy/pasteable snippets which you use in those examples, as [Markdown code blocks](https://help.github.com/articles/markdown-basics/#multiple-lines).
-   **Describe the current behavior** and **explain which behavior you expected to see instead** and why.
-   **Include screenshots and animated GIFs** which help you demonstrate the steps or point out what the suggestion is related to. You can use [this tool](https://www.cockos.com/licecap/) to record GIFs on macOS and Windows, and [this tool](https://github.com/colinkeenan/silentcast) or [this tool](https://github.com/GNOME/byzanz) on Linux.
-   **Explain why this enhancement would be useful**.
-   **List some other plugins where this enhancement exists.**

## Local development

All DumbDogDiner plugins and backend software can be developed locally. Contributions should be worked on in your own branches as described in

For Kotlin projects, we use [Gradle](https://gradle.org/) for compiling code and building jars. For Typescript projects, we use [Yarn](https://yarnpkg.org) as our package manager.

### Branch Naming Convention

To help everyone understand what you are currently working on in your branch, we ask you to abide by the following branch naming convention:

-   For a feature you are adding, use: `feat/<your username>/<short feature name>` e.g. `feat/skye/mail`.
-   For a bugfix, use: `bugfix/<your username>/<short bug name>` e.g. `bugfix/skye/overflow`.
-   For a critical patch to master, use `hotfix/master`.

### Pull Requests

The process described here has several goals:

-   Maintain the quality of DumbDogDiner's plugins
-   Fix problems that are important to players
-   Engage the community in working toward the best possible gameplay experience

Please follow these steps to have your contribution considered by the maintainers:

1. Follow all instructions in [the template](https://github.com/DumbDogDiner/.github/blob/master/ISSUE_TEMPLATE/feature_request.md)
2. Follow the [styleguides](#styleguides)
3. After you submit your pull request, verify that all [status checks](https://help.github.com/articles/about-status-checks/) are passing <details><summary>What if the status checks are failing?</summary>If a status check is failing, and you believe that the failure is unrelated to your change, please leave a comment on the pull request explaining why you believe the failure is unrelated. A maintainer will re-run the status check for you. If we conclude that the failure was a false positive, then we will open an issue to track that problem with our status check suite.</details>

While the prerequisites above must be satisfied prior to having your pull request reviewed, the reviewer(s) may ask you to complete additional design work, tests, or other changes before your pull request can be ultimately accepted.

## Styleguides

### Git Commit Messages

-   Use the present tense ("Add feature" not "Added feature")
-   Use the imperative mood ("Move cursor to..." not "Moves cursor to...")
-   Limit the first line to 72 characters or less
-   Reference issues and pull requests liberally after the first line

### Kotlin Styleguide

All Kotlin code is linted with [Prettier](https://prettier.io), using [prettier-plugin-kotlin](https://github.com/Angry-Potato/prettier-plugin-kotlin).

### Typescript Styleguide

All TypeScript code is formatted with [Prettier](https://prettier.io/), and is compliant with our [ESLint Style Configuration](https://github.com/DumbDogDiner/typescript-template).

-   Prefer the object spread operator (`{ ...anotherObj }`) to `Object.assign()`
-   Inline `export`s with expressions whenever possible

    ```ts
    // Use this:
    export class ClassName {}

    // Instead of:
    class ClassName {}
    export { ClassName };
    ```

-   Place requires in the following order - we recommend the use of [Typescript Import Sorter](https://marketplace.visualstudio.com/items?itemName=mike-co.import-sorter):
    -   Built in Node Modules (such as `path`)
    -   Local Modules (using relative paths)
-   Place class properties in the following order:
    -   Class methods and properties (methods starting with `static`)
    -   Instance methods and properties
-   [Avoid platform-dependent code](https://flight-manual.atom.io/hacking-atom/sections/cross-platform-compatibility/)

### Documentation Styleguide

-   Use [Google's JavaDoc Standard](https://google.github.io/styleguide/javaguide.html#s7-javadoc) for Java and Kotlin documentation.
-   Use [JSDoc](https://github.com/jsdoc/jsdoc) for TypeScript documentation.
-   Use [Markdown](https://daringfireball.net/projects/markdown) for directory-level documentation.
