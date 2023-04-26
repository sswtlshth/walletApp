# walletApp
Wallet Application

This project contains 
1. Wallet
2. Wallet-UI

==============Running (Wallet)springboot application using docker:==============
1. cd Wallet
2. docker build --tag wallet:wallet
3. docker run -p 8080:8080 wallet:wallet

================Running (Wallet-UI), React Application is dependent on spring boot service serving at 8080.==========
1. cd Wallet-UI
2. npm install
3. npm run

UI can be browsed on : http://localhost:3000/


Rest APIs details:
1. Create Wallet
    POST http://localhost:8080/wallets
    Payload: 
    {
        "name": <Wallet-Name>,
    }

2. Get all Wallets:
    GET http://<hostname>:<port>/wallets
   
3. Get all Wallets by name:
    GET http://localhost:8080/wallets/<wallet-name>
      
4. Make transaction (transactionType "ADD" to add funds, "WITHDRAW" to with funds):
   POST http://localhost:8080/transactions{
    "transactionType": "ADD",
    "amount":20000000000000000,
    "wallet":
        {
        "id":1
        }
    }
    
Replace localhost with hostname in case this apis needs to be accessed from other system.
