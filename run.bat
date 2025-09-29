@echo off
chcp 65001 > nul
echo Запуск DungeonMini...

cd /d "C:\Users\Segunfai\IdeaProjects\java_learning_second_module"
java -Dfile.encoding=UTF-8 -cp build\classes attestation02_dungeon.core.Main

pause