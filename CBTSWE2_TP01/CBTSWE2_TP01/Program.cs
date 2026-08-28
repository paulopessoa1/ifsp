/* 
 * Paulo Eduardo da Silva Pessoa - CB303092X
 */

using CBTSWE2_TP01;
using CBTSWE2_TP01.Repositorio;
using CBTSWE2_TP01.Testes;
using Microsoft.AspNetCore.Hosting;

// Executa a sua classe de testes
 BooktTest.Executar();


 Console.ReadLine();
 

var _repo = new BookRepositoryCSV();

IWebHost host = new WebHostBuilder()
    .UseKestrel()
    .UseStartup<Startup>()
    .Build();

host.Run();
