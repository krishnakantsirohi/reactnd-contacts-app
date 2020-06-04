import React, { Component } from 'react'
import ListContacts from './ListContacts'
import * as DataService from './DataService';


class App extends Component {
    state = {
        contacts: []
    }

    componentDidMount() {
        DataService.getAll()
            .then((contacts) => {
                this.setState(()=>({
                    contacts
                }))
            })
    }

    removeContact = (contact) => {
        DataService.removeContact(contact.id)
            .then((contacts)=>{
                this.setState(()=>({
                    contacts
                }))
            })
    }
    render() {
        return (
            <div>
                <ListContacts contacts={this.state.contacts} onDeleteContact={this.removeContact}/>
            </div>
        );
    }
}

export default App
