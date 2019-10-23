USE [master]
GO
/****** Object:  Database [jtys]    Script Date: 2019/10/23 23:38:01 ******/
CREATE DATABASE [jtys]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'jtys', FILENAME = N'D:\sqlserver\MSSQL11.MSSQLSERVER\MSSQL\DATA\jtys.ndf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'jtys_log', FILENAME = N'D:\sqlserver\MSSQL11.MSSQLSERVER\MSSQL\DATA\jtys_log.ldf' , SIZE = 1280KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [jtys] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [jtys].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [jtys] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [jtys] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [jtys] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [jtys] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [jtys] SET ARITHABORT OFF 
GO
ALTER DATABASE [jtys] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [jtys] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [jtys] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [jtys] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [jtys] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [jtys] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [jtys] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [jtys] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [jtys] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [jtys] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [jtys] SET  ENABLE_BROKER 
GO
ALTER DATABASE [jtys] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [jtys] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [jtys] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [jtys] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [jtys] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [jtys] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [jtys] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [jtys] SET RECOVERY FULL 
GO
ALTER DATABASE [jtys] SET  MULTI_USER 
GO
ALTER DATABASE [jtys] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [jtys] SET DB_CHAINING OFF 
GO
ALTER DATABASE [jtys] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [jtys] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'jtys', N'ON'
GO
USE [jtys]
GO
/****** Object:  Table [dbo].[allergy_history_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[allergy_history_form](
	[allergy_id] [bigint] NOT NULL,
	[card_id] [varchar](30) NOT NULL,
	[allergen] [varchar](255) NOT NULL,
	[describe] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[allergy_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[case_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[case_form](
	[Case_id] [bigint] NOT NULL,
	[card_id] [varchar](30) NOT NULL,
	[type] [varchar](255) NOT NULL,
	[hospital] [varchar](255) NOT NULL,
	[date] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Case_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Complaint_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Complaint_form](
	[id] [bigint] NOT NULL,
	[complainant] [varchar](255) NOT NULL,
	[doctor_id] [bigint] NOT NULL,
	[content] [varchar](255) NOT NULL,
	[time] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[device_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[device_form](
	[device_id] [bigint] NOT NULL,
	[model] [varchar](255) NOT NULL,
	[equipment_name] [varchar](255) NOT NULL,
	[type] [varchar](255) NULL,
	[purchase_time] [datetime2](7) NOT NULL,
	[purchaser] [varchar](255) NOT NULL,
	[price] [float] NOT NULL,
	[purchase_quantity] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[device_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[doctor_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[doctor_form](
	[doctor_id] [bigint] NOT NULL,
	[name] [varchar](255) NOT NULL,
	[age] [int] NOT NULL,
	[sex] [varchar](255) NOT NULL,
	[card_id] [varchar](255) NOT NULL,
	[duty] [varchar](255) NOT NULL,
	[department] [varchar](255) NOT NULL,
	[phone] [varchar](255) NOT NULL,
	[doctor_group_id] [bigint] NOT NULL,
	[hospital_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[doctor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[doctor_group_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[doctor_group_form](
	[doctor_group_id] [bigint] NOT NULL,
	[name] [varchar](255) NOT NULL,
	[group_leader_name] [varchar](255) NOT NULL,
	[group_leader_phone] [varchar](255) NOT NULL,
	[second_leader_name] [varchar](255) NOT NULL,
	[second_leader_phone] [varchar](255) NOT NULL,
	[speciality] [varchar](255) NOT NULL,
	[service_area] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[doctor_group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[evaluation_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[evaluation_form](
	[evaluation_id] [bigint] NOT NULL,
	[evaluator] [varchar](255) NOT NULL,
	[doctor_id] [bigint] NOT NULL,
	[evaluation_content] [varchar](255) NOT NULL,
	[time] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[evaluation_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[family_doctor_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[family_doctor_form](
	[family_doctor_id] [bigint] NOT NULL,
	[doctor_group_id] [bigint] NOT NULL,
	[family_id] [bigint] NOT NULL,
	[date_of_contract] [datetime2](7) NOT NULL,
	[contract_content] [text] NOT NULL,
	[contract_duration] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[family_doctor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[family_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[family_form](
	[family_id] [bigint] NOT NULL,
	[householder_name] [varchar](255) NOT NULL,
	[population] [int] NOT NULL,
	[householder_phone] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[family_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[family_history_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[family_history_form](
	[family_history_id] [bigint] NOT NULL,
	[card_id] [varchar](30) NOT NULL,
	[relation] [varchar](255) NOT NULL,
	[illness_name] [varchar](255) NOT NULL,
	[describe] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[family_history_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[family_member_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[family_member_form](
	[family_member_id] [bigint] NOT NULL,
	[name] [varchar](255) NOT NULL,
	[age] [int] NOT NULL,
	[sex] [varchar](255) NOT NULL,
	[card_id] [varchar](255) NOT NULL,
	[phone] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[family_id] [bigint] NOT NULL,
	[emergency_contact_name] [varchar](255) NOT NULL,
	[emergency_contact_phone] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[family_member_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Follow_up_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Follow_up_form](
	[Follow_up_id] [bigint] NOT NULL,
	[doctor] [varchar](255) NOT NULL,
	[accompanying] [varchar](255) NOT NULL,
	[type] [varchar](255) NOT NULL,
	[time] [datetime2](7) NOT NULL,
	[content] [varchar](255) NOT NULL,
	[family_id] [bigint] NOT NULL,
	[family_member_id] [bigint] NOT NULL,
	[health_assessment] [text] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Follow_up_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Health_knowledge_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Health_knowledge_form](
	[Health_knowledge_id] [bigint] NOT NULL,
	[title] [varchar](255) NOT NULL,
	[content] [varchar](255) NOT NULL,
	[publisher_id] [bigint] NOT NULL,
	[review_status] [varchar](5) NOT NULL,
	[reviewer] [varchar](255) NULL,
	[review_time] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[Health_knowledge_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[hospital_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[hospital_form](
	[hospital_id] [bigint] NOT NULL,
	[hospital_name] [varchar](255) NOT NULL,
	[address] [varchar](255) NOT NULL,
	[corporate] [varchar](255) NOT NULL,
	[phone] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[hospital_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Hospitalization_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Hospitalization_form](
	[Hospitalization_id] [bigint] NOT NULL,
	[case_id] [bigint] NOT NULL,
	[Hospitalization_number] [bigint] NOT NULL,
	[disease_type] [varchar](255) NOT NULL,
	[physician_number] [bigint] NOT NULL,
	[chief_physician] [varchar](255) NOT NULL,
	[admission_time] [datetime2](7) NOT NULL,
	[discharge_time] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Hospitalization_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Inspection_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Inspection_form](
	[Inspection_id] [bigint] NOT NULL,
	[case_id] [bigint] NOT NULL,
	[inspection_item] [varchar](255) NOT NULL,
	[inspection_time] [datetime2](7) NOT NULL,
	[ inspection_conclusion] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Inspection_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Measurement_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Measurement_form](
	[Measurement_id] [bigint] NOT NULL,
	[measurement_type] [varchar](255) NOT NULL,
	[unit] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Measurement_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Medication_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Medication_form](
	[Medication_id] [bigint] NOT NULL,
	[case_id] [bigint] NOT NULL,
	[ drug_name] [varchar](255) NOT NULL,
	[medication_time] [datetime2](7) NOT NULL,
	[precautions] [varchar](255) NOT NULL,
	[start_time] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Medication_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[menu_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[menu_form](
	[menu_id] [bigint] NOT NULL,
	[menu_name] [varchar](255) NOT NULL,
	[parent_id] [bigint] NULL,
	[rank] [int] NOT NULL,
	[url] [varchar](255) NOT NULL,
	[type] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[menu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[menu_role_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[menu_role_form](
	[menu_role_id] [bigint] NOT NULL,
	[role_id] [bigint] NOT NULL,
	[menu_id] [bigint] NOT NULL,
	[jurisdiction] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[menu_role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Notice_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Notice_form](
	[Notice_id ] [bigint] NOT NULL,
	[title] [varchar](255) NOT NULL,
	[content] [varchar](255) NOT NULL,
	[time] [datetime2](7) NOT NULL,
	[publisher] [varchar](255) NOT NULL,
	[unit_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[Notice_id ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[obsterical_history_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[obsterical_history_form](
	[obsterical_id] [bigint] NOT NULL,
	[card_id] [varchar](30) NOT NULL,
	[marriage] [varchar](25) NULL,
	[birth] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[obsterical_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[operation_history_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[operation_history_form](
	[operation_id] [bigint] NOT NULL,
	[card_id] [varchar](30) NOT NULL,
	[operation_name] [varchar](255) NOT NULL,
	[date] [datetime2](7) NOT NULL,
	[describe] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[operation_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[past_history_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[past_history_form](
	[past_id] [bigint] NOT NULL,
	[card_id] [varchar](30) NOT NULL,
	[describe] [text] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[past_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Purchase_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Purchase_form](
	[Purchase_id] [bigint] NOT NULL,
	[purchase_family_id] [bigint] NOT NULL,
	[purchase_time] [datetime2](7) NOT NULL,
	[device_id] [bigint] NOT NULL,
	[handle_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Purchase_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[role_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[role_form](
	[role_id] [bigint] NOT NULL,
	[role_name] [varchar](255) NOT NULL,
	[role_describe] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Self_check_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Self_check_form](
	[Self_check_id] [bigint] NOT NULL,
	[card_id] [varchar](30) NOT NULL,
	[measurement_id] [bigint] NOT NULL,
	[measurement_time] [datetime2](7) NOT NULL,
	[measurement_result] [varchar](255) NOT NULL,
	[device_id] [bigint] NULL,
	[device_source] [varchar](255) NULL,
	[usage_time] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[Self_check_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Service_record_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Service_record_form](
	[Service_id] [bigint] NOT NULL,
	[service_time] [datetime2](7) NOT NULL,
	[doctor_group_id] [bigint] NOT NULL,
	[family_id] [bigint] NOT NULL,
	[family_member_id] [bigint] NOT NULL,
	[service_content] [varchar](255) NOT NULL,
	[service_type] [varchar](255) NOT NULL,
	[service_evaluation] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Service_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Surgery_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Surgery_form](
	[Surgery_id] [bigint] NOT NULL,
	[case_id] [bigint] NOT NULL,
	[surgical_name] [varchar](255) NOT NULL,
	[operative_time] [datetime2](7) NOT NULL,
	[surgical_description] [varchar](255) NOT NULL,
	[surgeon] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Surgery_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Threshold_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Threshold_form](
	[id] [bigint] NOT NULL,
	[code] [varchar](255) NOT NULL,
	[preset_value] [varchar](255) NOT NULL,
	[measurement_type] [varchar](255) NOT NULL,
	[warning_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[unit_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[unit_form](
	[unit_id] [bigint] NOT NULL,
	[unit_name] [varchar](255) NOT NULL,
	[corporate] [varchar](255) NOT NULL,
	[phone] [varchar](255) NOT NULL,
	[address] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[unit_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user_form](
	[uesr_id] [bigint] NOT NULL,
	[user_name] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[unit] [bigint] NOT NULL,
	[doctor_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[uesr_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user_role_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_role_form](
	[user_role_id] [bigint] NOT NULL,
	[user_id] [bigint] NOT NULL,
	[role_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[warning_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[warning_form](
	[warning_id] [bigint] NOT NULL,
	[type] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[warning_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[warning_history_form]    Script Date: 2019/10/23 23:38:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[warning_history_form](
	[warning_history_id] [bigint] NOT NULL,
	[detector] [varchar](255) NOT NULL,
	[card_id] [varchar](30) NOT NULL,
	[content] [varchar](255) NOT NULL,
	[time] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[warning_history_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [master]
GO
ALTER DATABASE [jtys] SET  READ_WRITE 
GO
