## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# PRO-UD6-Duolingo

## What is this project?

This app refers to a dictionary that will save words introduced by the user, classifying them by the initial of said words.

The word will get its spaces eliminated and its capital letters will be turn into lower case letters.

The user will be able to do actions with those words like deleting them, check if they exist, show the valid initials for all saved words and even show all the initials saved for each capital letter.

![DUOLINGO]((https://raw.githubusercontent.com/JudelRos/PRO-UD6-Duolingo/main/assets/Menu_Duolingo.png))

1. **Add word** - The user is asked for a word to introduce into the system, then that said word is put into the wordContainer(TM) and classified by its initial, creating a new set for the initial if there isn't already one.

2. **Delete word** - The user is asked for a word to delete, if said word exists, then the word gets deleted from the system. If the word doesn't exist the user will receive a message telling him/her that the word is not valid.

3. **Does this word exist?** - The user is asked for a word to check. Then if the word exist the user will receive a message confirming that his/her word is already in the dictionary. If said word doesn't exist the user will receive a message telling them that the word doesn't exist in the dictionary.

4. **Show valid initials** - The user will receive a message telling them all the initials that have been used in the dictionary listed in order of input. If there are no words in the dictionary, the user will receive a message informing them that the dictionary is empty.

5. **Show words by initial** - The user will be asked for a letter to check all the saved words starting with that letter, showing them as spaces into the set that they are contained into. If the user selects a letter which has no words saved into them he/she will receive a message informing him/her that there are no words saved by that initial.
