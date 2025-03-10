# CoordsPlugin

**CoordsPlugin** is a simple Minecraft plugin designed to help players retrieve the coordinates of other players in the game world. It also allows players to find the nearest player and provides basic help commands.

🔹 **Features:**
- Retrieve the coordinates of a specific player with `/coords <playername>`
- Find the nearest player with `/coords nearest`
- View command help with `/coords help`

## ⚙️ Installation

To install the plugin:

1. Download the latest `CoordsPlugin.jar` release from [Releases](https://github.com/ExtroEd/coords-plugin-minecraft/releases).
2. Place the `.jar` file in the `plugins` directory of your Minecraft server.
3. Restart the server or use `/reload` to load the plugin.
4. Use `/coords` in-game to get started!

## 🔧 Build Instructions

To build the plugin from source, follow these steps:

1. Clone the repository:

    ```bash
    git clone https://github.com/ExtroEd/coords-plugin-minecraft.git
    cd coords-plugin-minecraft
    ```

2. Build the project with Gradle:

    ```bash
    ./gradlew build
    ```

   This will generate the plugin `.jar` file in the `build/libs` directory.

## 🔑 License

This project is licensed under the MIT License.

MIT License

Copyright (c) 2023 CIOCOLATA47
Modifications in 2025 by ExtroEd

## 🛠️ Commands

| Command                          | Description                                               |
|-----------------------------------|-----------------------------------------------------------|
| `/coords <playername>`            | Get coordinates of a specific player.                     |
| `/coords nearest`                 | Get coordinates of the nearest player to you.             |
| `/coords help`                    | Show a list of available commands and usage.               |

## 💬 Contributing

Feel free to fork the repository, make your changes, and submit pull requests. Contributions are always welcome!

---

Thank you for using **CoordsPlugin**! 🚀