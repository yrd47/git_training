from fabric.api import cd,run,env

__author__ = 'yrd'

env.host_string="192.168.96.21"
env.user ="dongyan.xu"
env.password = "I4WHSAyr"

with cd("/data/conf/me.ele.arch.das.lz"):
    run("sudo docker exec -it mysql_dal ls /data")