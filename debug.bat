@echo off
chcp 65001 > nul
cd /d "C:\Users\Segunfai\IdeaProjects\java_learning_second_module"

echo 1. Проверяем пакеты в Main.java...
findstr "package" src\attestation02_dungeon\core\Main.java

echo.
echo 2. Компилируем...
javac -d build\classes -encoding UTF-8 src\attestation02_dungeon\core\Main.java

echo.
echo 3. Проверяем созданные классы...
if exist build\classes\attestation02_dungeon\core\Main.class (
    echo ✅ Main.class создан!
    echo 4. Запускаем...
    java -cp build\classes attestation02_dungeon.core.Main
) else (
    echo ❌ Main.class не создан!
)

pause