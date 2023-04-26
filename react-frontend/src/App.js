import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

import HeaderComponent from './components/HeaderComponent';
import CreateWalletComponent from './components/CreateWalletComponent';
import ListWalletComponent from './components/ListWalletComponent';
import TransactionComponents from './components/TransactionComponents';

function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListWalletComponent}></Route>
                          <Route path = "/wallets" component = {ListWalletComponent}></Route>
                          <Route path = "/add-wallet/:id" component = {CreateWalletComponent}></Route>
                          <Route path = "/transaction/:transactionType/:id" component = {TransactionComponents}></Route>
                    </Switch>
                </div>
             
        </Router>
    </div>
    
  );
}

export default App;
