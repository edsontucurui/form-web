insert 
into 
pessoas (nome_completo, telefone, dt_nascimento, email, sexo, tecnologia , escolaridade )
values('Edson','999999','13/09/2000','','m','','');

select * 
from pessoas p 

update pessoas p
set dt_nascimento = '13/09/2000'
where p.nome_completo = 'Edson'