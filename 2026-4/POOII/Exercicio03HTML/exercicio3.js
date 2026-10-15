
// Aluna: Camilli dos Santos | RA: 12529495

class Endereco {
  constructor(rua, numero, cidade, uf, cep) {
    this.rua = rua;
    this.numero = numero;
    this.cidade = cidade;
    this.uf = uf;
    this.cep = cep;
  }

  toString() {
    return `${this.rua}, ${this.numero} - ${this.cidade}/${this.uf} - CEP ${this.cep}`;
  }
}

class Especialidade {
  constructor(nome, codigoConselho) {
    this.nome = nome;
    this.codigoConselho = codigoConselho;
  }

  toString() {
    return `${this.nome} (${this.codigoConselho})`;
  }
}

class Pessoa {
  constructor(nome, cpf, dataNascimento, endereco) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco; // objeto Endereco
  }

  getIdade() {
    const nascimento = new Date(this.dataNascimento);
    const hoje = new Date();
    let idade = hoje.getFullYear() - nascimento.getFullYear();
    const m = hoje.getMonth() - nascimento.getMonth();
    if (m < 0 || (m === 0 && hoje.getDate() < nascimento.getDate())) idade--;
    return idade;
  }

  apresentar() {
    return `${this.nome} (CPF ${this.cpf}, ${this.getIdade()} anos)`;
  }
}

class PlanoSaude {
  constructor(nomeOperadora, registroAns, categoria) {
    this.nomeOperadora = nomeOperadora;
    this.registroAns = registroAns;
    this.categoria = categoria; // Básico, Intermediário, Premium
  }

  toString() {
    return `${this.nomeOperadora} - ${this.categoria} (ANS ${this.registroAns})`;
  }
}

class Paciente extends Pessoa {
  constructor(nome, cpf, dataNascimento, endereco, numeroCarteirinha, planoSaude) {
    super(nome, cpf, dataNascimento, endereco);
    this.numeroCarteirinha = numeroCarteirinha;
    this.planoSaude = planoSaude; // objeto PlanoSaude
    this.consultas = [];
    this.exames = [];
    this.internacoes = [];
  }

  marcarConsulta(consulta) {
    this.consultas.push(consulta);
  }

  solicitarExame(exame) {
    this.exames.push(exame);
  }

  internar(internacao) {
    this.internacoes.push(internacao);
  }

  apresentar() {
    return `${super.apresentar()} | Carteirinha ${this.numeroCarteirinha} | Plano: ${this.planoSaude}`;
  }
}

class ProfissionalSaude extends Pessoa {
  constructor(nome, cpf, dataNascimento, endereco, registroProfissional) {
    super(nome, cpf, dataNascimento, endereco);
    this.registroProfissional = registroProfissional;
    this.agenda = [];
  }

  temHorarioLivre(dataHora) {
    return !this.agenda.includes(dataHora);
  }
}

class Medico extends ProfissionalSaude {
  constructor(nome, cpf, dataNascimento, endereco, registroProfissional, especialidade) {
    super(nome, cpf, dataNascimento, endereco, registroProfissional);
    this.especialidade = especialidade; // objeto Especialidade
  }

  solicitarExame(paciente, tipoExame, laboratorio) {
    const exame = new Exame(tipoExame, new Date().toISOString().slice(0, 10), paciente, this, laboratorio);
    paciente.solicitarExame(exame);
    return exame;
  }

  reavaliarPaciente(paciente, exame) {
    exame.resultado = exame.resultado || "Sem alterações relevantes";
    return `Dr(a). ${this.nome} reavaliou ${paciente.nome} com base no exame de ${exame.tipo}: ${exame.resultado}`;
  }

  apresentar() {
    return `Dr(a). ${this.nome} - ${this.especialidade} - CRM ${this.registroProfissional}`;
  }
}

class Fisioterapeuta extends ProfissionalSaude {
  constructor(nome, cpf, dataNascimento, endereco, registroProfissional, areaAtuacao) {
    super(nome, cpf, dataNascimento, endereco, registroProfissional);
    this.areaAtuacao = areaAtuacao;
  }

  aplicarSessao(paciente) {
    return `Sessão de fisioterapia (${this.areaAtuacao}) aplicada em ${paciente.nome}`;
  }

  apresentar() {
    return `Fisio. ${this.nome} - ${this.areaAtuacao} - CREFITO ${this.registroProfissional}`;
  }
}

class Hospital {
  constructor(nome, endereco, numeroLeitos) {
    this.nome = nome;
    this.endereco = endereco;
    this.numeroLeitos = numeroLeitos;
    this.internacoes = [];
  }

  registrarInternacao(internacao) {
    this.internacoes.push(internacao);
  }

  toString() {
    return `${this.nome} (${this.numeroLeitos} leitos)`;
  }
}

class Clinica {
  constructor(nome, endereco, especialidadesAtendidas) {
    this.nome = nome;
    this.endereco = endereco;
    this.especialidadesAtendidas = especialidadesAtendidas; // array de Especialidade
  }

  toString() {
    return `${this.nome} - especialidades: ${this.especialidadesAtendidas.map(e => e.nome).join(", ")}`;
  }
}

class Laboratorio {
  constructor(nome, endereco, credenciado) {
    this.nome = nome;
    this.endereco = endereco;
    this.credenciado = credenciado;
  }

  realizarExame(exame) {
    exame.resultado = `Exame realizado no laboratório ${this.nome}`;
    exame.laboratorio = this;
    return exame;
  }

  toString() {
    return `${this.nome} ${this.credenciado ? "(credenciado)" : "(não credenciado)"}`;
  }
}


class Consulta {
  constructor(data, horario, paciente, medico, tipo = "Primeira consulta") {
    this.data = data;
    this.horario = horario;
    this.paciente = paciente;   // objeto Paciente
    this.medico = medico;       // objeto Medico
    this.tipo = tipo;           // "Primeira consulta" ou "Retorno"
    this.status = "Agendada";
  }

  cancelar() {
    this.status = "Cancelada";
  }

  realizar() {
    this.status = "Realizada";
  }

  toString() {
    return `Consulta (${this.tipo}) de ${this.paciente?.nome ?? "?"} com ${this.medico?.nome ?? "?"} em ${this.data} ${this.horario} - ${this.status}`;
  }
}

class Exame {
  constructor(tipo, dataSolicitacao, paciente, medicoSolicitante, laboratorio) {
    this.tipo = tipo;
    this.dataSolicitacao = dataSolicitacao;
    this.paciente = paciente;
    this.medicoSolicitante = medicoSolicitante;
    this.laboratorio = laboratorio;
    this.resultado = null;
  }

  toString() {
    return `Exame de ${this.tipo} - paciente ${this.paciente?.nome ?? "?"} - solicitado por ${this.medicoSolicitante?.nome ?? "?"} - resultado: ${this.resultado ?? "pendente"}`;
  }
}

class Internacao {
  constructor(paciente, hospital, motivo, dataEntrada) {
    this.paciente = paciente;
    this.hospital = hospital;
    this.motivo = motivo;
    this.dataEntrada = dataEntrada;
    this.dataSaida = null;
  }

  darAlta(dataSaida) {
    this.dataSaida = dataSaida;
  }

  toString() {
    return `Internação de ${this.paciente?.nome ?? "?"} no ${this.hospital?.nome ?? "?"} (${this.motivo}) desde ${this.dataEntrada}` +
           (this.dataSaida ? ` até ${this.dataSaida}` : " - em andamento");
  }
}

function alocarClassesComValoresFixos() {
  const endereco1 = new Endereco("Rua das Flores", "120", "Jundiaí", "SP", "13201-000");
  const endereco2 = new Endereco("Av. Brasil", "500", "Campinas", "SP", "13010-000");
  const endereco3 = new Endereco("Rua da Saúde", "45", "Jundiaí", "SP", "13202-000");

  const cardiologia = new Especialidade("Cardiologia", "CRM-SP 12345");
  const ortopedia = new Especialidade("Ortopedia", "CRM-SP 54321");

  const plano1 = new PlanoSaude("Unifaj Saúde", "ANS-000123", "Premium");

  const paciente1 = new Paciente("Camilli dos Santos", "111.222.333-44", "1999-05-10", endereco1, "PL-98765", plano1);

  const medico1 = new Medico("Ana Beatriz Souza", "222.333.444-55", "1980-03-15", endereco2, "CRM-SP 111222", cardiologia);
  const fisio1 = new Fisioterapeuta("Rafael Lima", "333.444.555-66", "1985-07-22", endereco2, "CREFITO 22334", "Ortopédica");

  const hospital1 = new Hospital("Hospital Unifaj", endereco3, 120);
  const clinica1 = new Clinica("Clínica Vida Plena", endereco3, [cardiologia, ortopedia]);
  const laboratorio1 = new Laboratorio("Laboratório Central", endereco3, true);

  const consulta1 = new Consulta("2026-09-20", "09:00", paciente1, medico1, "Primeira consulta");
  paciente1.marcarConsulta(consulta1);

  const exame1 = medico1.solicitarExame(paciente1, "Eletrocardiograma", laboratorio1);
  laboratorio1.realizarExame(exame1);

  const consultaRetorno = new Consulta("2026-10-05", "10:30", paciente1, medico1, "Retorno");
  paciente1.marcarConsulta(consultaRetorno);
  const reavaliacao = medico1.reavaliarPaciente(paciente1, exame1);

  const internacao1 = new Internacao(paciente1, hospital1, "Observação clínica", "2026-09-25");
  hospital1.registrarInternacao(internacao1);
  paciente1.internar(internacao1);

  const sessaoFisio = fisio1.aplicarSessao(paciente1);

  return {
    endereco1, endereco2, endereco3,
    cardiologia, ortopedia,
    plano1,
    paciente1,
    medico1, fisio1,
    hospital1, clinica1, laboratorio1,
    consulta1, consultaRetorno,
    exame1,
    internacao1,
    reavaliacao,
    sessaoFisio
  };
}
