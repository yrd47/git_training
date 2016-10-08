port=3305
serverid=10
i=4

while [ $i -le 12 ] ; do 
    ((port=3305+i))
    ((serverid=108+i))
    file="my${i}.cnf"
    cp my.cnf.tmp ${file}
    echo $port $serverid $file
    sed -i -e "s/^port=.*/port=$port/1"  ${file}
    sed -i -e "s/^server-id=.*/server-id=$serverid/g"  ${file}
    sed -i -e "s/mysql2/mysql${i}/g"  ${file}
    sed -i -e "s/mysqld2/mysqld${i}/g"  ${file}
   
    mkdir /data/mysql/mysql${i}
    chown -R mysql.mysql /data/mysql/mysql${i}
    mysql_install_db --user=mysql --datadir=/data/mysql/mysql${i}/
    mysqld_safe --defaults-file=/data/mysql/conf/my${i}.cnf --init-file=/sandbox/mysql.init &
    ((i=i+1))
done
