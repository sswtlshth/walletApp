import React, { Component } from 'react'
import WalletService from '../services/WalletService';
import TransactionService from '../services/TransactionService';

class TransactionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            transactionType: this.props.match.params.transactionType,
            amount: ''
        }
        this.changeAmountHandler = this.changeAmountHandler.bind(this);
        this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
    }
 
    changeAmountHandler= (event) => {
        this.setState({amount: event.target.value});
    }

    saveOrUpdateEmployee = (e) => {
        e.preventDefault();
        let walletDetails = { id: this.state.id}
        let transaction = {transactionType: this.state.transactionType, amount: this.state.amount, wallet: walletDetails};
        TransactionService.addTransaction(transaction).then(res =>{
                this.props.history.push('/wallets');
            }); 
    }
  

    cancel(){
        this.props.history.push('/wallets');
    }

    getTitle(){
        if(this.state.transactionType === 'ADD'){
            return <h3 className="text-center">Add Funds</h3>
        }else{
            return <h3 className="text-center">Withdraw Funds</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Amount: </label>
                                            <input placeholder="Amount" name="account" className="form-control" 
                                                value={this.state.amount} onChange={this.changeAmountHandler}/>
                                        </div>
                                        <button className="btn btn-success" onClick={this.saveOrUpdateEmployee}>Save</button>
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

export default TransactionComponent
