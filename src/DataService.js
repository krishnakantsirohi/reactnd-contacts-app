const api = 'http://localhost:5001/';

export const getAll = () =>
    fetch(`${api}`)
        .then(res => res.json())
        .then(data => data)

export const removeContact = (id) =>
    fetch(`${api}+${id}`, {method: 'DELETE'})
        .then(res => res.json())
        .then(data => data)

export const addContact = (contact) =>
    fetch(`${api}`, {method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(contact)})
        .then(data=>data.json())
        .then(data=>data)