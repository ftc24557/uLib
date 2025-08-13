
# uLib
A uLib é uma biblioteca criada pelas equipes Unimate (FTC24557 e FRC10190), criado para padronizar e externalizar a arquitetura de código utilizado pela equipe no âmbito da FTC.
A biblioteca e sua documentação estão em constante desenvolvimento e melhora, para qualquer sugestão, apoio ou ajuda, entre em contato por meio do Instagram (@team_unimate).
## **Subsystem**
### **O que é um Subsystem?**
Um subsistema é um sistema de baixo nível do robô que opera o hardware diretamente, referenciando especificamente os componentes físicos do robô.
### **Criando um Subsystem**
Para criar um subsistema, é preciso criar um arquivo novo com o nome correspondente, seguindo o seguinte template:

	package org.firstinspires.ftc.teamcode.core.examples;

	import com.qualcomm.robotcore.hardware.HardwareMap;
	import com.qualcomm.robotcore.hardware.Servo;

	import org.firstinspires.ftc.robotcore.external.Telemetry;
	import org.firstinspires.ftc.teamcode.core.lib.Subsystem;

	public class ClawOuttake extends Subsystem {
	    Servo servo;
	    @Override
	    public void Init(HardwareMap hardwareMap, Telemetry telemetry) /* O init recebe o hardwareMap atual do robô e a sua telemetria */ {
	    // Dentro da definição do Init, as classes dependentes do hardwareMap são instanciados
	        servo = hardwareMap.get(Servo.class, "");
	    }
		// Dentro da classe, são instanciados métodos próprios referentes ao subsistema
	    public void Close(){
	        servo.setPosition(1);
	    }
	    public void Open(){
	        servo.setPosition(0);
	    }

		// O Periodic é chamado a cada "loop" do robô
	    @Override
	    public void Periodic() {

	    }
	}
	
	
## **SubSystemGroup**
### **O que é um SubSystemGroup?**
Um grupo de subsistemas faz exatamente o que o nome sugere, ele agrupa os subsistemas e os opera em mais alto nível.
### **Criando um SubSystemGroup**
Para criar um grupo de subsistemas, é preciso criar um arquivo com o mesmo nome do grupo seguindo o seguindo o seguinte template:

	package org.firstinspires.ftc.teamcode.core.examples;

	import com.qualcomm.robotcore.hardware.HardwareMap;

	import org.firstinspires.ftc.robotcore.external.Telemetry;
	import org.firstinspires.ftc.teamcode.core.lib.StateMachine.Action;
	import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;
	import org.firstinspires.ftc.teamcode.core.lib.Subsystem;

	public class OuttakeGroup extends SubSystemGroup {
	    //Aqui devem ser criados os subsistemas do grupo
	    PivotArmOuttake pivotArmOuttake;
	    ClawOuttake clawOuttake;
	    public OuttakeGroup(){
		    //Instancie os subsistemas e os coloque dentro de um array
	         pivotArmOuttake= new PivotArmOuttake();
	         clawOuttake= new ClawOuttake();
	        Subsystem[] subsystems = {
	                pivotArmOuttake,
	                clawOuttake
	        };
			//Utilize o método scheduleSubsystems, que recebe o array dos subsistemas
	        scheduleSubsystems(subsystems);

	    }
	    //Os métodos que operam os subsistemas são criados dentro da classe para que possam ser utilizadas em alto nível
	    public void ToOuttake(){
	        clawOuttake.Close();
	        pivotArmOuttake.PivotToScore();
	    }
	    public void ToIntake(){

	        clawOuttake.Open();
	        pivotArmOuttake.PivotToCatch();
	    }
		
	    @Override
	    public void GroupPeriodic(Telemetry telemetry) {
		    //O GroupPeriodic é chamado a cada "loop" do robô
	    }
	}		
## Robot

### **O que é?**

É a classe referente ao do robô utilizado, por meio dela acessamos os seus SubsystemGroups e executamos as suas ações.

### **Métodos**
			
		.Init(HardwareMap hardwareMap, Telemetry telemetry)
		//Inicializa os subsistemas dos grupos do robô.
		
		.Periodic(Telemetry telemetry)
		//Executa os periodics dos grupos de subsistemas.
### **Alterando o MainRobot**
O quickstart já conta com uma instância da classe Robot que já está estruturada dentro do TeleOp1, nela você deve criar os seus subsystemGroups, dessa forma:
package org.firstinspires.ftc.teamcode;

	import org.firstinspires.ftc.teamcode.core.lib.Robot;
	import org.firstinspires.ftc.teamcode.core.lib.SubSystemGroup;

	public class MainRobot extends Robot {
	    /*
	    Instancie os seus grupos aqui, exemplo:
	    public static Drivetrain drive = new Drivetrain();
	    */
	    public static SubSystemGroup[] subSystemGroups = {
	            /*
	            Referencie os grupos criados aqui, exemlo:
	            drive,
	            */
	    };
	    public MainRobot() {
	        super(subSystemGroups);
	    }
	}
### **OpModes usando o Robot**
O projeto também conta com um template que mostra a ordem em que os métodos do robô devem ser executados:

	package org.firstinspires.ftc.teamcode;

	import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
	import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

	@TeleOp
	public class Teleop1 extends LinearOpMode {
	    @Override
	    public void runOpMode(){

	        MainRobot mainRobot = new MainRobot();
	        mainRobot.Init(hardwareMap, telemetry);

	        waitForStart();

	        while (!isStopRequested()){
	            mainRobot.Periodic(telemetry);
	        }
	    }
	}
## PIDFController

### **O que é um Controlador PID?**

Um **controlador PID** é um mecanismo de <ins>feedback control</ins> loop que regula certas variáveis, como temperatura, nível de água, e no nosso caso, a <ins>força de motores</ins>. O vídeo abaixo explica sobre os controladores PID mais aprofundadamente.

https://www.youtube.com/watch?v=gNG7ep0HPII 

### **Utilizando**

A classe PIDFController recebe <ins>4 parâmetros</ins>, o P, I, D, e o F, que correspondem aos parâmetros do controlador. Abaixo temos a lista de métodos relacionados à classe **PIDFController**.
	
### **Métodos**

		
		new PIDFController(double kP, double kI, double kD, double kF) 
		.setSetpoint(setpoint)
		//Recebe um valor double, e o determina como o setpoint do controlador.
		
		.getSetpoint()
		//Retorna o setpoint atual.
		
		.setTolerance(tolerance)
		//Recebe um valor double, e usa como a margem de tolerância para o método atSetPoint.
		
		.atSetpoint( )
		//Retorna uma boolean sendo true caso o setpoint for atingido segudo a tolerância e false caso o setpoint ainda não tenha sido atingido.
		
		.reset( )
		//Reseta os valores associados a erro do controlador.
		
		.calculate(currentPosition)
		//Recebe a posição atual e faz o cálculo do PIDf e retorna o mesmo, use como a força a ser aplicada no motor.
