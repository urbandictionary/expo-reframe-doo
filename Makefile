default:
	cat Makefile

deploy:
	lein prod-build
	exp publish

test:
	lein with-profile +test doo node test
