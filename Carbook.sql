USE [master]
GO
/****** Object:  Database [Carbook]    Script Date: 04/02/2021 17:39:10 ******/
CREATE DATABASE [Carbook]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Carbook', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Carbook.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Carbook_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Carbook_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Carbook] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Carbook].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Carbook] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Carbook] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Carbook] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Carbook] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Carbook] SET ARITHABORT OFF 
GO
ALTER DATABASE [Carbook] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Carbook] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Carbook] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Carbook] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Carbook] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Carbook] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Carbook] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Carbook] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Carbook] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Carbook] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Carbook] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Carbook] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Carbook] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Carbook] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Carbook] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Carbook] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Carbook] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Carbook] SET RECOVERY FULL 
GO
ALTER DATABASE [Carbook] SET  MULTI_USER 
GO
ALTER DATABASE [Carbook] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Carbook] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Carbook] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Carbook] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Carbook] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Carbook] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Carbook', N'ON'
GO
ALTER DATABASE [Carbook] SET QUERY_STORE = OFF
GO
USE [Carbook]
GO
/****** Object:  Table [dbo].[commento]    Script Date: 04/02/2021 17:39:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[commento](
	[id_commento] [int] IDENTITY(1,1) NOT NULL,
	[post_id_post] [int] NOT NULL,
	[persona_email] [varchar](40) NOT NULL,
	[media_commento] [varbinary](max) NULL,
	[data_ora_commento] [datetime] NOT NULL,
	[contenuto_commento] [varchar](500) NOT NULL,
 CONSTRAINT [id_commento] PRIMARY KEY CLUSTERED 
(
	[id_commento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[evento]    Script Date: 04/02/2021 17:39:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[evento](
	[cod_evento] [int] IDENTITY(1,1) NOT NULL,
	[email_creatore] [varchar](40) NOT NULL,
	[email_partecipante] [varchar](40) NULL,
	[nome] [varchar](50) NOT NULL,
	[luogo] [varchar](50) NOT NULL,
	[data_ora_evento] [datetime] NOT NULL,
	[num_partecipanti] [int] NULL,
	[descrizione] [varchar](1000) NULL,
 CONSTRAINT [id] PRIMARY KEY CLUSTERED 
(
	[cod_evento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[messaggio]    Script Date: 04/02/2021 17:39:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[messaggio](
	[id_messaggio] [int] IDENTITY(1,1) NOT NULL,
	[persona_email_mittente] [varchar](40) NOT NULL,
	[persona_email_destinatario] [varchar](40) NOT NULL,
	[contenuto] [varchar](1000) NOT NULL,
	[data_ora_messaggio] [datetime] NOT NULL,
 CONSTRAINT [PK_id_messaggio] PRIMARY KEY CLUSTERED 
(
	[id_messaggio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[persona]    Script Date: 04/02/2021 17:39:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[persona](
	[email] [varchar](40) NOT NULL,
	[nome] [varchar](40) NOT NULL,
	[cognome] [varchar](40) NOT NULL,
	[data_nascita] [datetime] NULL,
	[citta] [varchar](40) NULL,
	[password] [varchar](50) NOT NULL,
	[username] [varchar](50) NOT NULL,
 CONSTRAINT [email] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[post]    Script Date: 04/02/2021 17:39:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[post](
	[id_post] [int] IDENTITY(1,1) NOT NULL,
	[cod_evento] [int] NULL,
	[persona_email] [varchar](40) NOT NULL,
	[descrizione] [varchar](1000) NOT NULL,
	[media] [varbinary](max) NOT NULL,
 CONSTRAINT [PK_post] PRIMARY KEY CLUSTERED 
(
	[id_post] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[commento]  WITH CHECK ADD  CONSTRAINT [FK_commento_persona] FOREIGN KEY([persona_email])
REFERENCES [dbo].[persona] ([email])
GO
ALTER TABLE [dbo].[commento] CHECK CONSTRAINT [FK_commento_persona]
GO
ALTER TABLE [dbo].[commento]  WITH CHECK ADD  CONSTRAINT [FK_commento_post] FOREIGN KEY([post_id_post])
REFERENCES [dbo].[post] ([id_post])
GO
ALTER TABLE [dbo].[commento] CHECK CONSTRAINT [FK_commento_post]
GO
ALTER TABLE [dbo].[evento]  WITH CHECK ADD  CONSTRAINT [FK_evento_persona_creatore] FOREIGN KEY([email_creatore])
REFERENCES [dbo].[persona] ([email])
GO
ALTER TABLE [dbo].[evento] CHECK CONSTRAINT [FK_evento_persona_creatore]
GO
ALTER TABLE [dbo].[evento]  WITH CHECK ADD  CONSTRAINT [FK_evento_persona_partecipante] FOREIGN KEY([email_partecipante])
REFERENCES [dbo].[persona] ([email])
GO
ALTER TABLE [dbo].[evento] CHECK CONSTRAINT [FK_evento_persona_partecipante]
GO
ALTER TABLE [dbo].[messaggio]  WITH CHECK ADD  CONSTRAINT [FK_messaggio_persona_destinatatio] FOREIGN KEY([persona_email_destinatario])
REFERENCES [dbo].[persona] ([email])
GO
ALTER TABLE [dbo].[messaggio] CHECK CONSTRAINT [FK_messaggio_persona_destinatatio]
GO
ALTER TABLE [dbo].[messaggio]  WITH CHECK ADD  CONSTRAINT [FK_messaggio_persona_mittente] FOREIGN KEY([persona_email_mittente])
REFERENCES [dbo].[persona] ([email])
GO
ALTER TABLE [dbo].[messaggio] CHECK CONSTRAINT [FK_messaggio_persona_mittente]
GO
ALTER TABLE [dbo].[post]  WITH CHECK ADD  CONSTRAINT [FK_post_persona] FOREIGN KEY([persona_email])
REFERENCES [dbo].[persona] ([email])
GO
ALTER TABLE [dbo].[post] CHECK CONSTRAINT [FK_post_persona]
GO
USE [master]
GO
ALTER DATABASE [Carbook] SET  READ_WRITE 
GO
