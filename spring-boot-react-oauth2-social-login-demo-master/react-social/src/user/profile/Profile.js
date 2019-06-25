import React, { Component } from 'react';
import './Profile.css';
import {TabView,TabPanel} from 'primereact/tabview';

class Profile extends Component {
	constructor(props) {
		super(props);

		console.log(props);
	}
	render() {
		return (
			<div className="profile-container">
				<div className="container">
					<div className="profile-info">
						<div className="profile-avatar">
							{
								this.props.currentUser.imageUrl ? (
									<img src={this.props.currentUser.imageUrl} alt={this.props.currentUser.name} />
								) : (
										<div className="text-avatar">
											<span>{this.props.currentUser.name && this.props.currentUser.name[0]}</span>
										</div>
									)
							}
						</div>
						<div className="profile-name">
							<h2>{this.props.currentUser.name}</h2>
							<p className="profile-email">{this.props.currentUser.email}</p>
						</div>

						<div>
							<div className="content-section introduction">
								<div className="feature-intro">
									<h1>TabView</h1>
									<p>TabView is a container component to group content with tabs.</p>
								</div>
							</div>

							<div className="content-section implementation">
								<TabView renderActiveOnly={false}>
									<TabPanel header="Godfather I" leftIcon="pi pi-calendar">
										<p>The story begins as Don Vito Corleone, the head of a New York Mafia family, overseeshis daughter's wedding. His beloved son ichael has just come home from the war,
										but does not intend to become part of his father's business. Through Michael's life the nature of the family business becomes clear. The business of the family is
                            just like the head of the family, kind and benevolent to those who give respect, but given to ruthless violence whenever anything stands against the good of the family.</p>
									</TabPanel>
									<TabPanel header="Godfather II" rightIcon="pi pi-user">
										<p>Francis Ford Coppola's legendary continuation and sequel to his landmark 1972 film, The_Godfather parallels the young Vito Corleone's rise with his son Michael's spiritual fall,
										deepening The_Godfather's depiction of the dark side of the American dream. In the early 1900s, the child Vito flees his Sicilian village for America after the local Mafia kills
                            his family. Vito struggles to make a living, legally or illegally, for his wife and growing brood in Little Italy.</p>
									</TabPanel>
									<TabPanel header="Godfather III" leftIcon="pi pi-search" rightIcon="pi pi-check">
										<p>The Godfather Part III is set in 1979 and 1980. Michael has moved back to New York and taken great strides to remove the family from crime. He turns over his New York criminal
										interests to longtime enforcer Joey Zasa. He uses his wealth in an attempt to rehabilitate his reputation through numerous philanthropic acts, administered by a foundation named after his father.
                            A decade earlier, he gave custody of his two children to Kay, who has since remarried.</p>
									</TabPanel>
									<TabPanel header="Godfather IV" disabled={true}>

									</TabPanel>
								</TabView>

								<h3>Controlled</h3>
								<TabView activeIndex={this.state.activeIndex} onTabChange={(e) => this.setState({ activeIndex: e.index })}>
									<TabPanel header="Godfather I" leftIcon="pi pi-calendar">
										<p>The story begins as Don Vito Corleone, the head of a New York Mafia family, overseeshis daughter's wedding. His beloved son ichael has just come home from the war,
										but does not intend to become part of his father's business. Through Michael's life the nature of the family business becomes clear. The business of the family is
                            just like the head of the family, kind and benevolent to those who give respect, but given to ruthless violence whenever anything stands against the good of the family.</p>
									</TabPanel>
									<TabPanel header="Godfather II" rightIcon="pi pi-user">
										<p>Francis Ford Coppola's legendary continuation and sequel to his landmark 1972 film, The_Godfather parallels the young Vito Corleone's rise with his son Michael's spiritual fall,
										deepening The_Godfather's depiction of the dark side of the American dream. In the early 1900s, the child Vito flees his Sicilian village for America after the local Mafia kills
                            his family. Vito struggles to make a living, legally or illegally, for his wife and growing brood in Little Italy.</p>
									</TabPanel>
									<TabPanel header="Godfather III" leftIcon="pi pi-search" rightIcon="pi pi-check">
										<p>The Godfather Part III is set in 1979 and 1980. Michael has moved back to New York and taken great strides to remove the family from crime. He turns over his New York criminal
										interests to longtime enforcer Joey Zasa. He uses his wealth in an attempt to rehabilitate his reputation through numerous philanthropic acts, administered by a foundation named after his father.
                            A decade earlier, he gave custody of his two children to Kay, who has since remarried.</p>
									</TabPanel>
									<TabPanel header="Godfather IV" disabled={true}>

									</TabPanel>
								</TabView>
							</div>
						</div>

					</div>
				</div>
			</div>

		);
	}
}

export default Profile