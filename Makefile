default:
	cat Makefile

deploy:
	lein prod-build
	exp publish
