CopaDeadlock
============

Projeto do Problema 02 do Padrões e Frameworks, Estatisticas da Copa do Mundo da FIFA.

Abrindo o projeto no Eclipse
================================================

1 - Para as alterações realizadas neste repositório, a versão do <b>Eclipse</b> a ser utilizada será a 4.3 
(<b>Eclipse Kepler</b>), que pode ser baixada para os sistemas operacionais Windows, Linux e Mac neste link:

http://www.eclipse.org/downloads/

2 - Também é necessário instalar o cliente de controle de versão <b>GIT</b>, que pode ser baixado neste endereço:

http://git-scm.com/

3 - Tendo instalado o Eclipse Kepler e o GIT, abra o Eclipse, na perspectiva "<i>Git Repository Exploring</i>". Clique no 
botão "<i>Clone a Git Repository and add the clone to this view</i>". 

<img src="http://docs.joomla.org/images/b/bd/Git-coders-tutorial-20121009-01.png" />

No campo URI, cole o endereço deste repositório:

https://github.com/sfohart/jabref-2.9.2.git

Clicando em "next", você poderá ver todos os branches disponíveis neste repositório. Neste caso, os seguintes branches estarão 
disponíveis:

<ul>
	<li>master</li>
	<li>phase-01</li>
</ul>

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/branch-selection.PNG" />

Clicando mais uma vez em "next", você poderá configurar em qual diretório o Eclipse clonará o repositório git.

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/local-destination.PNG" />

É recomendável que você deixe a configuração como está. Clique em "Finish" e o Eclipse fará o download dos 
arquivos deste repositório para o seu computador.

4 - Crie um branch local de nome "phase-01" 

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/criando-branch-local.png" />

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/criando-branch-local-phase-01.png" />

Ainda na aba <i>Git Repository Exploring</i>, visualize os branchs locais. Na aba <i>Properties</i> você 
verá as configurações para o branch remoto

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/configurando-push-01.PNG" />

Selecione o branch recém criado <i>phase-01</i> lique no botão Edit

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/configurando-push-03.PNG" />

Configure para o branch remoto respectivo, como na imagem abaixo

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/configurando-push-02.PNG" />


5 - Expanda o diretório de trabalho, clique com o botão direito do mouse na pasta "<b>jabref-2.9.2</b>" e selecione
a opção <b>Import Projects...</b>. Clique em "next" e, depois, em "finish"

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/import-projects.png" />

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/import-projects-01.png" />

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/import-projects-02.png" />

6 - Abra a visão do <b>Ant</b>, clicando em Window > Show View > Ant

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/configurando-ant.png" />

Clique no botão <b>Add buildfiles</b>

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/configurando-ant-01.png" />

Selecione o arquivo <b>build.xml</b> e clique no botão <b>OK</b>

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/configurando-ant-02.png" />

Para compilar e executar o projeto, execute a task <b>run</b> deste build file.

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/configurando-ant-03.PNG" />


Requisições de Mudança - Fase 01
===================================================

Durante a primeira fase de requisições de mudança, todas as alterações deverão ser comitadas dentro do branch
<b>phase-01</b>. Qualquer commit realizado em outro branch, para esta fase, implicará na invalidação da nota do grupo
para esta fase. Atentem para o fato de que cada commit é identificado com o login do respectivo desenvolvedor.


<ul>
	<li><b>Mudança 01:</b> Incluir nome de cada membro da equipe na tela "Ajuda > Sobre JabRef", dentro da seção 
	"Contributions from".</li>
	
	<li><b>Mudança 02:</b> Utilizar por padrão um único tema para a aplicação em todas as plataformas possíveis  
	(Windows, Linux ou Mac), ao invés de utilizar o tema padrão do sistema operacional</li>
	
	<li><b>Mudança 03:</b> Alterar o esquema de cores do menu Editar > Marcar cor específica, de modo que as 
	cores padrão exibidas neste submenu correspondam às cores abaixo (em hexadecimal), nesta ordem:

	<ul>
		<li>#F3E778</li>
		<li>#F1E6AF</li>
		<li>#F4BC7B</li>
		<li>#D96842</li>
		<li>#D83E3E</li>
	</ul>

	Verificar se, por algum motivo, as cores anteriores estão gravadas em algum arquivo de configuração, 
	ou no registro do sistema operacional. Neste caso, limpe tais informações antes de testar.</li>
	
	<li><b>Mudança 04:</b> Altere a tecla de atalho do ítem de menu "Arquivo > Fechar base de dados" de 
	"Ctrl+W" para "Ctrl+Shift+W".</li>
	
	<li><b>Mudança 05:</b> Modifique a tela de conexão com o banco de dados de modo que, ao selecionar o 
	tipo de servidor MySQL, o usuário seja "<b>root</b>", e ao selecionar o tipo PostgreSQL, o usuário 
	seja "<b>postgres</b>".</li>
	
	<li><b>Mudança 06:</b> Na tela de edição de entradas Bibtex, para a aba de edição do código 
	fonte bibtex, altere a tabulação: ao invés de dois espaços em branco, utilize o caractere de tabulação</li>
</ul>

Commitando alterações
===================================================

1 - Adicione todos os arquivos ao índice local do git, clicando com o botão direito do mouse no projeto, e 
selecionando "Team > Add to Index"

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/commitando-alteracoes.png" />

2 - Efetue o commit das suas alterações, realizando os devidos comentários. Para isso, clique com o botão direito
do mouse no projeto e selecione "Team > Commit...". Isso é importante para a rastreabilidade das modificações 
no código fonte. 

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/commitando-alteracoes-01.png" />

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/commitando-alteracoes-02.png" />

Localmente, você pode efetuar quantos commits achar necessário.

3 - Após encerrar as modificações, efetuar os testes e validar o resultado da alteração, efetue o commit no
repositório remoto (GitHub). Para isso, clique com o botão direito do mouse no projeto, e selecione
"Team > Remote > Push..."

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/commitando-alteracoes-03.png" />

4 - Selecione o repositório remoto. Neste caso, existe apenas um (origin). Deixe como está e clique em "next"

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/commitando-alteracoes-04.png" />

5 - Em "Source ref", selecione o branch local phase-01. Em "Destination ref", selecione o branch remoto "phase-01".
Clique em "Add Spec". Feito isso, clique em "next". Caso a listagem já exiba configuração semelhante, 
este passo não é necessário.

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/commitando-alteracoes-05.png" />

6 - A próxima tela é uma simulação do commit no repositório remoto. Estando tudo OK, como exibido na imagem 
abaixo, clique em "Finish"

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/commitando-alteracoes-06.png" />


<b>IMPORTANTE</b>: Lembre-se de que, antes de realizar um commit no repositório remoto, você deve deixar o 
projeto num estado compilável, ou seja, <b>não deixe erros de compilação no projeto</b>! Além disso, lembre-se 
(novamente) de que cada commit é identificado com o login do usuário.

Atualizando branch local
===================================================

Atente-se para o fato de que outras equipes estão efetuando alterações no mesmo branch, e possivelmente estas 
alterações podem alterar arquivos nos quais você está trabalhando. Deste modo, atualize o seu branch local, clicando
com o botão direito do mouse no projeto, e selecionando "Team > Pull".

<img src="https://raw.github.com/sfohart/jabref-2.9.2/master/doc/atualizando-branch-local.png" />

O GIT, em muitos casos, efetua o merge dos arquivos de código fonte de modo automático. Isso acontece normalmente 
em casos onde há modificações no mesmo arquivo, porém, em regiões diferentes. Quando as modificações ocorrem na mesma
região de um arquivo, o git apresenta tais modificações como abaixo:

<img src="http://eclipsesource.com/blogs/wp-content/uploads/2011/05/screenshot_085.png" />

Suas alterações estarão entre

```
<<<<<<<HEAD
=======
```

As alterações conflitantes no repositório remoto se encontrarão entre um código semelhante ao abaixo

```
=======
>>>>>>>refs/head/xpto
```

Analise o que deve ser alterado e remova AMBAS as marcações. Feito isso, adicione o arquivo ao índice do git 
(veja seção <i>Commitando alterações</i>). Resolvidos todos os conflitos, commite os arquivos no seu 
repositório local.
