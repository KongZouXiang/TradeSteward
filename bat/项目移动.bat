@echo off

:: ����ԴĿ¼
set sourcePath=..\Tradesteward

::����Ŀ��·��
set resulePath=..\��Ŀ����\%date:~0,4%"��"%date:~5,2%"��"%date:~8,2%"��"%time:~0,2%%time:~3,2%%time:~6,2%\Tradesteward

::md ..\��Ŀ����\%date:~0,4%"��"%date:~5,2%"��"%date:~8,2%"��"%time:~0,2%%time:~3,2%%time:~6,2%\Tradesteward

::/E ����Ŀ¼����Ŀ¼�������յ�
::/Y ��ֹ��ʾ��ȷ�ϸ�дһ��
::/F ����ʱ��ʾ������Դ��Ŀ���ļ���
::/H Ҳ�������غ�ϵͳ�ļ�

echo d|xcopy /l "%sourcePath%\*" "%resulePath%"

::xcopy target  ��Ŀ����\%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,2%\target /s /e /l /d
pause