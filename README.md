# walletApp
Wallet Application

This project contains 
1. Wallet
2. Wallet-UI

1. Running (Wallet)springboot application using docker:
cd Wallet
docker build --tag wallet:wallet
docker run -p 8080:8080 wallet:wallet

2. Running (Wallet-UI), React Application is dependent on spring boot service serving at 8080.
cd Wallet-UI
npm install
npm run


Rest APIs details:
1. Create Wallet
    POST http://<hostname>:<port>/wallets
    Payload: 
    {
        "name": <Wallet-Name>,
    }

2. Get all Wallets:
    GET http://<hostname>:<port>/wallets
   
3. Get all Wallets by name:
    GET http://<hostname>:<port>/wallets/<wallet-name>
      
4. Make transaction (transactionType "ADD" to add funds, "WITHDRAW" to with funds):
   POST http://localhost:8080/transactions{
    "transactionType": "ADD",
    "amount":20000000000000000,
    "wallet":
        {
        "id":1
        }
    }