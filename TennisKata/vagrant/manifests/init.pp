group { "puppet":
     ensure => "present",
}
include java

node "tomcat.cc.de" {
	include '::mysql::server' 	
	include tomcat
	Exec { path => [ "/bin/", "/sbin/" , "/usr/bin/", "/usr/sbin/" ] }
	
	package { "unzip":
		ensure => "installed",
		require => [Exec['apt-update'],],
	}
	exec { "apt-update":
		command	=> "/usr/bin/apt-get update",
	}

#        tomcat::war {'deploy':
#          source => '../target/',
#          staging => true,
#          warfile => '../target/TennisKata-0.0.1-SNAPSHOT.jar',
#        }
}

#class { '::mysql::server':
#  root_password    => 'toor',
#  databases	=> { 'opencms' => {'ensure' => 'present'}},
#  users		=> { 'opencms@localhost' => {'ensure' => 'present'
#			, password_hash => mysql_password(opencms),},},
#  grants	=> { 'opencms' => {'ensure' => 'present',
#			privileges  => ["ALL"],
#        		table       => "*.*",
#		        user        => "opencms@localhost",
#		}, },
#override_options => { 'mysqld' => { 'max_allowed_packet' => '64M' } }
#}

#class { '::mysql::server::providers':
#	create_resources('mysql_database', $mysql::server::databases)
#}
