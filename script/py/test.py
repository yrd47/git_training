from fabric.api import execute, env, put, hide,run
import os

SERVER = '192.168.65.25'
USER = 'www-data'
PASSWD = '1qaz@WSX'

env.hosts = [SERVER]
env.user = USER
env.password = PASSWD

def test():
    a = run("ls /home/www-data")
    print a

if os.path.exists(os.path.expanduser("~/.ssh/config")):
    env.use_ssh_config = True

with hide('aborts', 'stdout', 'running'):
    execute(test)