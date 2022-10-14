build :
	docker build -t purple-cow .
	docker volume create item-database
	docker run -p 3000:3000 purple-cow 