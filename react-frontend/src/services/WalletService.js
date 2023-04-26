import axios from 'axios';

const WALLET_API_BASE_URL = "http://localhost:8080/wallets";

class WalletService {

    getWallets(){
        return axios.get(WALLET_API_BASE_URL);
    }

    createWallet(wallet){
        return axios.post(WALLET_API_BASE_URL, wallet);
    }

    getWalletById(walletId){
        return axios.get(WALLET_API_BASE_URL + '/' + walletId);
    }

}

export default new WalletService()