import React, { Component } from 'react'
import WalletService from '../services/WalletService';

class CreateWalletComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            name: ''
        }
        this.changeWalletNameHandler = this.changeWalletNameHandler.bind(this);
       
        this.saveWallet = this.saveWallet.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }
    }
    saveWallet = (e) => {
        e.preventDefault();
        let wallet = {name: this.state.walletName, balance: 0};
        console.log('wallet => ' + JSON.stringify(wallet));

        if(this.state.id === '_add'){
            WalletService.createWallet(wallet).then(res =>{
                this.props.history.push('/wallets');
            });
        }
    }
    
    changeWalletNameHandler= (event) => {
        this.setState({walletName: event.target.value});
    }


    cancel(){
        this.props.history.push('/wallets');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add Wallet</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Wallet Name: </label>
                                            <input placeholder="Wallet Name" name="walletName" className="form-control" 
                                                value={this.state.walletName} onChange={this.changeWalletNameHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveWallet}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateWalletComponent
