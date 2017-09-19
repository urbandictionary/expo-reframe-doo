default:
	cat Makefile

deploy:
	lein prod-build
	exp publish

.PHONY: test
test:
	lein with-profile +test doo node test
