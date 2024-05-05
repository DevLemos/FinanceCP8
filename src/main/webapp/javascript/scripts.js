const tabs = document.querySelectorAll('.tab-btn');

//Percorrendo todas as tabs, e adicionando um evento de click para a tab clicada
tabs.forEach(tab => tab.addEventListener('click', () => tabClicked(tab)));

//Criando função

const tabClicked = (tab) =>{

tabs.forEach(tab => tab.classList.remove('active'));
tab.classList.add('active');


const contents = document.querySelectorAll('.content');

contents.forEach(content => content.classList.remove('show'));

const contentId = tab.getAttribute('content-id');
const content = document.getElementById(contentId);

content.classList.add('show');

}

const currentActiveTab = document.querySelector('.tab-btn.active');
tabClicked(currentActiveTab);
