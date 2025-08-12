# Documentação do uLib

# PIDFController

**O que é um Controlador PID?**

Um **controlador PID** é um mecanismo de <ins>feedback control</ins> loop que regula certas variáveis, como temperatura, nível de água, e no nosso caso, a <ins>força de motores</ins>. O vídeo abaixo explica sobre os controladores PID mais aprofundadamente.

https://www.youtube.com/watch?v=gNG7ep0HPII 

**Utilizando**

A classe PIDFController recebe <ins>4 parâmetros</ins>, o P, I, D, e o F. Abaixo temos a lista de métodos relacionados à classe **PIDFController**.
	
**Métodos**

		.setSetpoint( )
		Recebe um valor double, e usa como o setpoint.
		
		.getSetpoint( )
		Retorna o setpoint atual.
		
		.setTolerance( )
		Recebe um valor double, e usa como a margem de tolerância.
		
		.atSetpoint( )
		Retorna uma boolean sendo verdadeira caso o setpoint for atingido.
		
		.reset( )
		Reseta o erro, tempo desde o último erro e o IntegralSum para 0.
		
		.calculate( )
		Faz o cálculo do PID, e retorna o mesmo, use como a força a ser aplicada no motor.





# StateMachine

**O que é?**

É o “sistema de controle” principal do uLib, você utiliza ele para montar os <ins>subsistemas</ins>, os <ins>grupos de subsistemas</ins>, <ins>agendar seus comandos</ins>, e outas funções.

**Action**

Representa uma <ins>ação</ins>.
 
**Robot**

A classe base que <ins>representa o robô</ins>, é responsável pelo <ins>gerenciamento dos subsistemas</ins>, junto do loop principal. Estenda seu código com essa classe para usar.

**Métodos**

		.Run( )
		Recebe um valor int que representa quantos milissegundos até a ação ser iniciada.
	
		.Init( )
		Inicializa os subsistemas do robô.
		
		.Periodic( )
		Executa os loops periodics dos grupos de subsistemas.

**SubSystemGroup**

Essa classe representa um <ins>grupo de subsistemas</ins>, ideal para agrupar várias <ins>funcionalidades do robô</ins>, como um braço, elevador, e outros sistemas.

**Métodos**
		
		.scheduleSubsystems( )
		Define os subsistemas que pertencem a um grupo.
		
		.InitSubsystems( )
		Chama o método Init( ) de todos os subsistemas do grupo.
		
		.GroupPeriodic( )
		Deve ser chamado para inicializar os periodics dos subsistemas.
		
**Subsystem**

Uma classe que agrupa vários componentes do robô, como <ins>encoders, motores, servos, sensores, câmeras, entre outros</ins>.
	
**Métodos**
		
		.Init( )
		Inicializa os componentes do subsistema.
		
		.Periodic( )
		Executado múltiplas vezes enquanto o robô estiver ativo.
	
