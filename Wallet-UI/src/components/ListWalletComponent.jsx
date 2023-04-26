import React, { Component } from 'react'
import WalletService from '../services/WalletService'

class ListWalletComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                wallets: []
        }
        this.addWallet = this.addWallet.bind(this);
    }

    withdrawFunds(id){
        this.props.history.push(`/transaction/WITHDRAW/${id}`);
    }

    addFunds(id){
        this.props.history.push(`/transaction/ADD/${id}`);
    }

    componentDidMount(){
        WalletService.getWallets().then((res) => {
            console.log(res.data);
            this.setState({ wallets: res.data});
        });
    }

    addWallet(){
        this.props.history.push('/add-wallet/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">All Wallets</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addWallet}> Add Wallet</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Wallet Name</th>
                                    <th> Balanace</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.wallets.map(
                                        wallet => 
                                        <tr key = {wallet.id}>
                                             <td> {wallet.name} </td>   
                                             <td> {wallet.balance}</td>
                                             <td>
                                                 <button onClick={ () => this.addFunds(wallet.id)} className="btn btn-info">Add Funds </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.withdrawFunds(wallet.id)} className="btn btn-info">Withdraw Funds </button>
                                             </td>
                                        </tr>
                                    )
                                    }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListWalletComponent
