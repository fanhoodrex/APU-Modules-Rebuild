using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Foodie.Startup))]
namespace Foodie
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
