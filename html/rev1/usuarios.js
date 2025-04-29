/*document.addEventListener('DOMContentLoaded',carregarUsuarios)


const carregarUsuarios = () => {
    fetch('http://localhost:8080/usuarios')
    .then(response => {
        if (!response.ok){
            throw new Error('Erro ao buscar usuarios.')
        }
        response.json()
    })
    .then(usuarios => {
        const lista = document.getElementById('lista usuarios')
    })

    if (usuarios.lenght  === 0){
        list.innerHTML = '<li>Nenhum usuario encontrado. </li>'
        return
    }

    usuarios.forEach(usuario => {
        const item = document.createElement('li')
        item.innerHTML = `<strong> Nome: </strong> ${usuario.nome} <br> 
                            <strong> E-mail </strong> ${usuario.email}`
        list.appendChild(item)
        
    });
    .catch( erro => {
        document.getElementById('listaUsuarios').innerHTML = 
        '<li> Erro ao carregar usuarios </li>'
    })
}
*/

document.addEventListener('DOMContentLoaded', carregarUsuarios)

const carregarUsuarios = () => {
    fetch('http://localhost:8080/usuarios')
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao buscar usuarios.')
        }
        return response.json();  // Corrigido para retornar o JSON da resposta
    })
    .then(usuarios => {
        const listaUsuarios = document.getElementById('listaUsuarios')  // Consistência no nome da variável
        listaUsuarios.innerHTML = '';  // Limpa qualquer conteúdo anterior da lista

        if (usuarios.length === 0) {
            listaUsuarios.innerHTML = '<li>Nenhum usuário encontrado.</li>';
            return;
        }

        usuarios.forEach(usuario => {
            const item = document.createElement('li');
            item.innerHTML = `<strong>Nome:</strong> ${usuario.nome} <br> 
                              <strong>E-mail:</strong> ${usuario.email}`;
            listaUsuarios.appendChild(item);  // Adiciona o item à lista
        });
    })
    .catch(erro => {
        document.getElementById('listaUsuarios').innerHTML = 
        '<li>Erro ao carregar usuários.</li>';
    });
}
