@echo off

:: 定义源目录
set sourcePath=..\Tradesteward

::定义目标路径
set resulePath=..\项目备份\%date:~0,4%"年"%date:~5,2%"月"%date:~8,2%"日"%time:~0,2%%time:~3,2%%time:~6,2%\Tradesteward

::md ..\项目备份\%date:~0,4%"年"%date:~5,2%"月"%date:~8,2%"日"%time:~0,2%%time:~3,2%%time:~6,2%\Tradesteward

::/E 复制目录和子目录，包括空的
::/Y 禁止提示以确认改写一个
::/F 复制时显示完整的源和目标文件名
::/H 也复制隐藏和系统文件

echo d|xcopy /l "%sourcePath%\*" "%resulePath%"

::xcopy target  项目备份\%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,2%\target /s /e /l /d
pause